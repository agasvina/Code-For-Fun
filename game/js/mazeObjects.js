var MazeNode = function(row,col){
	var n = new PIXI.Sprite(mazeNodeTexture);
	n.interactive = true;
	n.position.x = mazeOffsetX + col*mazeWallLen;
	n.position.y = mazeOffsetY + row*mazeWallLen;
	n.anchor.x = 0.5;
	n.anchor.y = 0.5;
	n.click = startRotateNode;
	n.rotate = rotateNode;
	n.rotating = false;
	n.wup = null;
	n.wdown = null;
	n.wleft = null;
	n.wright = null;
	n.row = row;
	n.col = col;
	
	n.addLeftWall = addLeftWall;
	n.addRightWall = addRightWall;
	n.addDownWall = addDownWall;
	n.addUpWall = addUpWall;
	
	n.nup = null;
	n.ndown = null;
	n.nleft = null;
	n.nright = null;
	
	stage.addChild(n);
	return n;
};

var startRotateNode = function(){
	if(this.rotating){
		return;
	}
	if(this.nup != null && this.nup.rotating){
		return;
	}
	if(this.ndown != null && this.ndown.rotating){
		return;
	}
	if(this.nleft != null && this.nleft.rotating){
		return;
	}
	if(this.nright != null && this.nright.rotating){
		return;
	}
	
	if(checkBusy.call(this)){
		return;
	}
	
	if(this.nup != null && this.nup.wdown != null){
		stage.removeChild(this.nup.wdown);
		this.nup.wdown = null;
	}
	if(this.ndown != null && this.ndown.wup != null){
		stage.removeChild(this.ndown.wup);
		this.ndown.wup = null;
	}
	if(this.nleft != null && this.nleft.wright != null){
		stage.removeChild(this.nleft.wright);
		this.nleft.wright = null;
	}
	if(this.nright != null && this.nright.wleft != null){
		stage.removeChild(this.nright.wleft);
		this.nright.wleft = null;
	}

	blockCellsWhileRotating.call(this);
	
	this.rotating = true;
	this.rotateUntil = this.rotation + Math.PI/2;
};

var rotateNode = function(){
	this.rotation += 0.1;
	if(this.wup != null){
		this.wup.rotation += 0.1;
	}
	if(this.wdown != null){
		this.wdown.rotation += 0.1;
	}
	if(this.wleft != null){
		this.wleft.rotation += 0.1;
	}
	if(this.wright != null){
		this.wright.rotation += 0.1;
	}
	if(this.rotation >= this.rotateUntil){
		this.rotation = this.rotateUntil;
		this.rotating = false;
		clearSurroundingCells.call(this);
		var temp = this.wup;
		this.wup = null;
		if(this.wleft != null){
			stage.removeChild(this.wleft);
			this.wleft = null;
			this.addUpWall();
		}
		if(this.wdown != null){
			stage.removeChild(this.wdown);
			this.wdown = null;
			this.addLeftWall();
		}
		if(this.wright != null){
			stage.removeChild(this.wright);
			this.wright = null;
			this.addDownWall();
		}
		if(temp != null){
			stage.removeChild(temp);
			this.addRightWall();
		}
	}
};

var clearSurroundingCells = function(){
	maze.cells[this.row*2+1][this.col*2+2] = 0;
	maze.cells[this.row*2+1][this.col*2] = 0;
	maze.cells[this.row*2+2][this.col*2+1] = 0;
	maze.cells[this.row*2][this.col*2+1] = 0;
	maze.cells[this.row*2+2][this.col*2+2] = 0;
	maze.cells[this.row*2+2][this.col*2] = 0;
	maze.cells[this.row*2][this.col*2+2] = 0;
	maze.cells[this.row*2][this.col*2] = 0;
}

var blockCellsWhileRotating = function(){
	if(this.wup != null){
		maze.cells[this.row*2][this.col*2+2] = 1;
		maze.cells[this.row*2+1][this.col*2+2] = 1;
	}
	if(this.wright != null){
		maze.cells[this.row*2+2][this.col*2+2] = 1;
		maze.cells[this.row*2+2][this.col*2+1] = 1;
	}
	if(this.wdown != null){
		maze.cells[this.row*2+2][this.col*2] = 1;
		maze.cells[this.row*2+1][this.col*2] = 1;
	}
	if(this.wleft != null){
		maze.cells[this.row*2][this.col*2+1] = 1;
		maze.cells[this.row*2][this.col*2] = 1;
	}
}

var checkBusy = function(){
	var cellsToOccupy = [];
	if(this.wup != null){
		cellsToOccupy.push({row:this.row*2, col:this.col*2+2});
	}
	if(this.wright != null){
		cellsToOccupy.push({row:this.row*2+2, col:this.col*2+2});
	}
	if(this.wdown != null){
		cellsToOccupy.push({row:this.row*2+2, col:this.col*2});
	}
	if(this.wleft != null){
		cellsToOccupy.push({row:this.row*2, col:this.col*2});
	}
	
	var busyCells = [];
	busyCells.push({row:guy.destination.row, col:guy.destination.col});
	if(guy.occupiesStartCell){
		busyCells.push({row:guy.row, col:guy.col});
	}
	busyCells.push({row:anubis.destination.row, col:anubis.destination.col});
	if(anubis.occupiesStartCell){
		busyCells.push({row:anubis.row, col:anubis.col});
	}
	
	var i;
	var j;
	for(i=0; i<cellsToOccupy.length; i++){
		for(j=0; j<busyCells.length; j++){
			if(cellsToOccupy[i].row == busyCells[j].row && cellsToOccupy[i].col == busyCells[j].col){
				return true;
			}
		}
	}
	
	return false;
}

var Wall = function(node,rotation){
	var wall = new PIXI.Sprite(mazeWallTexture);
	wall.position.x = node.position.x;
	wall.position.y = node.position.y;
	wall.anchor.x = 0;
	wall.anchor.y = 0.5;
	wall.rotation = rotation;
	
	stage.addChild(wall);
	return wall;
}

var addRightWall = function(){
	if(this.wright != null){
		return;
	}
	
	this.wright = Wall(this,0);
	maze.cells[this.row*2+1][this.col*2+2] = 1;
	
	if(this.nright != null){
		this.nright.addLeftWall();
	}
}

var addLeftWall = function(){
	if(this.wleft != null){
		return;
	}
	
	this.wleft = Wall(this,Math.PI);
	maze.cells[this.row*2+1][this.col*2] = 1;
	
	if(this.nleft != null){
		this.nleft.addRightWall();
	}
}

var addUpWall = function(){
	if(this.wup != null){
		return;
	}
	
	this.wup = Wall(this,(Math.PI/2)*3);
	maze.cells[this.row*2][this.col*2+1] = 1;
	
	if(this.nup != null){
		this.nup.addDownWall();
	}
}

var addDownWall = function(){
	if(this.wdown != null){
		return;
	}
	
	this.wdown = Wall(this,Math.PI/2);
	maze.cells[this.row*2+2][this.col*2+1] = 1;
	
	if(this.ndown != null){
		this.ndown.addUpWall();
	}
}

var Maze = function(row,col){
	var m = [];
	var i=0;
	var j=0;
	for(i=0; i<row; i++){
		m.push([]);
		for(j=0; j<col; j++){
			m[i].push(MazeNode(i,j));
		}
	}

	for(i=0; i<row; i++){
		for(j=0; j<col; j++){
			if(j-1 >= 0){
				m[i][j].nleft = m[i][j-1];
			}
			if(j+1 < col){
				m[i][j].nright = m[i][j+1];
			}
			if(i-1 >= 0){
				m[i][j].nup = m[i-1][j];
			}
			if(i+1 < row){
				m[i][j].ndown = m[i+1][j];
			}
		}
	}
	
	m.cells = [];
	for(i=0; i<row*2+1; i++){
		m.cells.push([]);
		for(j=0; j<col*2+1; j++){
			if((i%2 == 1)&&(j%2 == 1)){
				m.cells[i].push(1);
			} else {
				m.cells[i].push(0);
			}
		}
	}
	
	m.generateWalls = function(walls){
		var wallsArr = [];
		for(i=0; i<row+1; i++){
			for(j=0; j<col; j++){
				if(!((i == row)&&(j == 0) || (i == 0)&&(j == col-1))){
					wallsArr.push({row:i, col:j})
				}
			}
		}
		wallsArr.sort(function() { return 0.5 - Math.random() });
		for(i=0; i<walls/2; i++){
			if(wallsArr[i].row == row){
				this[wallsArr[i].row-1][wallsArr[i].col].addDownWall();
			} else {
				this[wallsArr[i].row][wallsArr[i].col].addUpWall();
			}
		}

		wallsArr = [];
		for(i=0; i<row; i++){
			for(j=0; j<col+1; j++){
				if(!((i == row-1)&&(j == 0) || (i == 0)&&(j == col))){
					wallsArr.push({row:i, col:j})
				}
			}
		}
		wallsArr.sort(function() { return 0.5 - Math.random() });
		for(i=0; i<walls/2; i++){
			if(wallsArr[i].col == col){
				this[wallsArr[i].row][wallsArr[i].col-1].addRightWall();
			} else {
				this[wallsArr[i].row][wallsArr[i].col].addLeftWall();
			}
		}
	}
	
	m.logCells = function(){
		for(i=0; i<this.cells.length; i++){
			console.log(this.cells[i].join(""));
		}
	}
	
	return m;
};
