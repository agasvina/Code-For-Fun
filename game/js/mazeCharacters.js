var Character = function(texture,texture2,row,col,animSpeed){
	var ch = new PIXI.Sprite(texture);
	ch.altTexture = texture2;
	
	ch.position.x = mazeOffsetX-mazeWallLen/2+col/2*mazeWallLen;
	ch.position.y = mazeOffsetY-mazeWallLen/2+row/2*mazeWallLen;
	ch.anchor.x = 0.5;
	ch.anchor.y = 0.5;
	
	ch.row = row;
	ch.col = col;

	ch.changeTexture = function(){
		var altT = this.altTexture;
		this.altTexture = this.texture;
		this.setTexture(altT);
	}

	ch.animationSpeed = animSpeed;
	
	ch.move = function(){
		if(this.row == this.destination.row && this.col == this.destination.col){
			this.decideDirection();
		}
		
		if(this.direction == "up" ){
			this.y--;
			if(this.y <= this.destination.y){
				this.y = this.destination.y;
				this.row = this.destination.row;
			}
		}
		if(this.direction == "down" ){
			this.y++;
			if(this.y >= this.destination.y){
				this.y = this.destination.y;
				this.row = this.destination.row;
			}
		}
		if(this.direction == "left" ){
			this.x--;
			if(this.x <= this.destination.x){
				this.x = this.destination.x;
				this.col = this.destination.col;
			}
		}
		if(this.direction == "right" ){
			this.x++;
			if(this.x >= this.destination.x){
				this.x = this.destination.x;
				this.col = this.destination.col;
			}
		}
		
		if(Math.abs(this.x-this.destination.x)+Math.abs(this.y-this.destination.y) < mazeWallLen/2){
			this.occupiesStartCell = false;
		}
	}
	
	ch.setDirection = function(dir){
		this.direction = dir;
		
		if(this.direction == "up" ){
			this.destination.row -= 2;
			this.destination.y -= mazeWallLen;
			this.rotation = 0;
		}
		if(this.direction == "down" ){
			this.destination.row += 2;
			this.destination.y += mazeWallLen;
			this.rotation = Math.PI;
		}
		if(this.direction == "right" ){
			this.destination.col += 2;
			this.destination.x += mazeWallLen;
			this.rotation = Math.PI/2;
		}
		if(this.direction == "left" ){
			this.destination.col -= 2;
			this.destination.x -= mazeWallLen;
			this.rotation = Math.PI/2*3;
		}
		
		this.occupiesStartCell = true;
	}
	
	ch.direction = "up";
	ch.destination = {row:row, col:col, x:ch.x, y:ch.y};
	ch.occupiesStartCell = false;
	
	stage.addChild(ch);
	setInterval(function (){ch.changeTexture();}, ch.animationSpeed);
	return ch
}

var randomDirection = function() {
		var up = false;
		var down = false;
		var left = false;
		var right = false;
		
		if(this.direction == undefined){
			this.direction = "up";
		}
		
		if(this.row>=2 && maze.cells[this.row-1][this.col] == 0 && maze.cells[this.row-2][this.col] == 0){
			up = true;
		}
		if(this.row<=maze.cells.length-3 && maze.cells[this.row+1][this.col] == 0 && maze.cells[this.row+2][this.col] == 0){
			down = true;
		}
		if(this.col>=2 && maze.cells[this.row][this.col-1] == 0 && maze.cells[this.row][this.col-2] == 0){
			left = true;
		}
		if(this.col<=maze.cells[0].length-3 && maze.cells[this.row][this.col+1] == 0 && maze.cells[this.row][this.col+2] == 0){
			right = true;
		}

		var directions = [];
		if(this.direction == "up" ){
			directions.push("up");
			directions = directions.concat(["left","right"].sort(function() { return 0.5 - Math.random() }));
			directions.push("down");
		}
		if(this.direction == "down" ){
			directions.push("down");
			directions = directions.concat(["left","right"].sort(function() { return 0.5 - Math.random() }));
			directions.push("up");
		}
		if(this.direction == "left" ){
			directions.push("left");
			directions = directions.concat(["up","down"].sort(function() { return 0.5 - Math.random() }));
			directions.push("right");
		}
		if(this.direction == "right" ){
			directions.push("right");
			directions = directions.concat(["up","down"].sort(function() { return 0.5 - Math.random() }));
			directions.push("left");
		}
		
		var i = 0;
		while(eval(directions[i]) == false){
			i++;
		}
		
		this.setDirection(directions[i]);
	};

var Guy = function(){
	var g = Character(PIXI.Texture.fromImage("img/man1.png"),PIXI.Texture.fromImage("img/man2.png"),mazeRows*2,0,750);
	
	g.decideDirection = randomDirection;
	
	return g;
}

var Anubis = function(){
	var a = Character(PIXI.Texture.fromImage("img/anubis1.png"),PIXI.Texture.fromImage("img/anubis2.png"),0,mazeCols*2,401);
	
	a.decideDirection = function() {
		var grid = new PF.Grid(maze.cells[0].length, maze.cells.length, maze.cells);
		var finder = new PF.AStarFinder();
		var path = finder.findPath(a.col, a.row, guy.col, guy.row, grid);
		var dir = "";
		if(path.length == 0){
			randomDirection.call(this);
		} else {
			if(path[2][0] < this.col){
				dir = "left";
			}
			if(path[2][0] > this.col){
				dir = "right";
			}
			if(path[2][1] < this.row){
				dir = "up";
			}
			if(path[2][1] > this.row){
				dir = "down";
			}
			this.setDirection(dir);
		}
	};
	
	return a;
}