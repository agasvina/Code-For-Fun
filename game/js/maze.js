var mazeWallLen = 130;
var mazeOffsetX = 140;
var mazeOffsetY = 170;

var stage;
var renderer;
var mazeNodeTexture = PIXI.Texture.fromImage("img/crate.jpg");
var mazeWallTexture = PIXI.Texture.fromImage("img/gate.png");

var mazeRows = 3;
var mazeCols = 5;

var maze;
var guy;
var anubis;

$(document).ready(function() {
	stage = new PIXI.Stage(0x000000,true);
	renderer = PIXI.autoDetectRenderer(800, 600);
    $("#centerframe").append(renderer.view);

	var back = new PIXI.Sprite(PIXI.Texture.fromImage("img/mazebg.png"));
	back.position.x = 0;
	back.position.y = 0;
	stage.addChild(back);
	
	requestAnimFrame(animate);
	
	maze = Maze(mazeRows,mazeCols);
	maze.generateWalls(16);
	
	guy = Guy();
	anubis = Anubis();
	mazeWallTexture.setFrame(new PIXI.Rectangle(0, 0, mazeWallLen, 20));

});

function animate() {
    requestAnimFrame( animate );
	
	var i;
	
	var i=0;
	var j=0;
	for(i=0; i<maze.length; i++){
		for(j=0; j<maze[i].length; j++){
			if(maze[i][j].rotating){
				maze[i][j].rotate();
			}
		}
	}

	if(guy.x == anubis.x && guy.y == anubis.y){
		console.log("FAIL");
		window.location.href='gameover.html';
	}

	if(guy.row == 0 && guy.col == maze.cells[0].length-1){
		guy.setDirection("right");
		console.log("WIN");
		setTimeout(function(){window.location.href='ending.html';},2000)
	}
	
	guy.move();
	anubis.move();
    renderer.render(stage);
}
