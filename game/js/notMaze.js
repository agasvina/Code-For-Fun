var stage;
var renderer;
var archeologist;
var scarab;
var goldDust;
var trans;

var alpha = 0.15;

var aXS = 25;
var aYS = 28;
var aInitX = 4;
var aInitY = 6;

var tXS = 25;
var tYS = 28;
var tX = 3;
var tY = 0;

var scXS = 765;
var scYS = 575;
var scInitX = -3;
var scInitY = 5;

var brickPos = [];
var brickSprite;
var brickCounter = 0;

var brickTexture = PIXI.Texture.fromImage("img/balok.png");
var rAT =  [PIXI.Texture.fromImage("img/jet1_kanan.png"), PIXI.Texture.fromImage("img/jet2_kanan.png")];
var lAT =  [PIXI.Texture.fromImage("img/jet1_kiri.png"), PIXI.Texture.fromImage("img/jet2_kiri.png")];
var rST =  [PIXI.Texture.fromImage("img/kepak1_kanan.png"), PIXI.Texture.fromImage("img/kepak2_kanan.png")];
var lST =  [PIXI.Texture.fromImage("img/kepak1_kiri.png"), PIXI.Texture.fromImage("img/kepak2_kiri.png")];
var goldT = [PIXI.Texture.fromImage("img/gold1.png"), PIXI.Texture.fromImage("img/gold2.png")]
var counterArr = [PIXI.Texture.fromImage("img/1.png"), PIXI.Texture.fromImage("img/2.png"), PIXI.Texture.fromImage("img/3.png"), PIXI.Texture.fromImage("img/4.png"), PIXI.Texture.fromImage("img/5.png"), PIXI.Texture.fromImage("img/6.png"), PIXI.Texture.fromImage("img/7.png")];

$(document).ready(function() {
	// create an new instance of a pixi stage
	stage = new PIXI.Stage(0x66FF99, true);			
	stage.click = createBrick;
	renderer = PIXI.autoDetectRenderer(800, 600);	
    $("#centerframe").append(renderer.view);
	
	bgT = PIXI.Texture.fromImage("img/back_rozi_new.jpg");
	bgS = new PIXI.Sprite(bgT);
	bgS.anchor.x = 0;
    bgS.anchor.y = 0;
	bgS.position.x = 0;
    bgS.position.y = 0;
	stage.addChild(bgS);
	
	archeologist = createObject(rAT, aInitX, aInitY, aXS, renderer.height - aYS, true);
		
	scarab = createObject(lST, scInitX, scInitY, scXS, scYS, false);
	
	ranY = Math.floor((Math.random() * 0.5 * renderer.height));
	ranX = Math.floor((Math.random() * renderer.width));
	goldDust = createObject(goldT, 0, 0, ranX, ranY, false);
	
	counterObj = createSimpleObject(counterArr[counterArr.length - brickCounter - 1], renderer.width - 50, 50);
	
    stage.addChild(archeologist);		
	stage.addChild(scarab);
	stage.addChild(goldDust);
	stage.addChild(counterObj);
	requestAnimFrame(animate);
});

function animate() {
    requestAnimFrame( animate );
	animateArcheologist();
	animateScarab();
	animateTrans();
    renderer.render(stage);
}