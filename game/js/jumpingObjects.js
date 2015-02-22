function createObject(archTexture, sX, sY, pX, pY, rD){
	var arch = new PIXI.Sprite(archTexture[0]);
	arch.altTexture = archTexture[1];
	arch.anchor.x = 0.5;
    arch.anchor.y = 0.5;
	arch.speedX = sX;
	arch.speedY = sY;	
	arch.position.x = pX;
    arch.position.y = pY;
	arch.rightDir = rD;
	
	arch.changeTexture = function(){
		var altT = this.altTexture;
		this.altTexture = this.texture;
		this.setTexture(altT);
	}
	
	setInterval(function (){arch.changeTexture();}, 500);
	
	return arch;
}

function createSimpleObject(texture, pX, pY){
	var obj = new PIXI.Sprite(texture);
	obj.anchor.x = 0.5;
	obj.anchor.y = 0.5;
	obj.position.x = pX;
	obj.position.y = pY;
	
	return obj;
}

function animateArcheologist(){
	if(!archeologist)
		return;
		
	if(win()){
		window.location.href='dust.html';
	}
		
	if(die()){
		transformArch(archeologist.speedX, archeologist.speedY, archeologist.rightDir);
		setTimeout(function(){window.location.href='gameover.html'},500);
	}
		
	collideBox(archeologist, aInitY);
	
	if(archeologist.position.y - archeologist.speedY + aYS >= renderer.height)
		archeologist.speedY = aInitY;
		
	if((archeologist.position.x + (0.5 * archeologist.width) + archeologist.speedX >= renderer.width) || (archeologist.position.x - aXS + archeologist.speedX  < 0)){
		sX = archeologist.speedX * -1;
		sY = archeologist.speedY; 
		pX = archeologist.position.x;
		pY = archeologist.position.y; 
		rD = !archeologist.rightDir;
		changeArcheologistDirection(rAT, sX, sY, pX, pY, rD);
	}
		
	archeologist.speedY -= alpha;
	archeologist.position.x += archeologist.speedX;
	archeologist.position.y -= archeologist.speedY;
}

function transformArch(tX, tY, rD){
	pX = archeologist.position.x;
	pY = archeologist.position.y;
	stage.removeChild(archeologist);
	archeologist = null;
	if(rD){
		trans = createObject(rST, tX, tY, pX, renderer.height - aYS, rD);
		stage.addChild(trans);
	}else{
		trans = createObject(lST, tX, tY, pX, renderer.height - aYS, rD);
		stage.addChild(trans);
	}	
}

function animateTrans(){
	if(!trans)
		return;
		
	if((trans.position.x + (0.5 * trans.width) + trans.speedX >= renderer.width) || (trans.position.x - aXS + trans.speedX  < 0)){
		sX = trans.speedX * -1;
		sY = trans.speedY; 
		pX = trans.position.x;
		pY = trans.position.y; 
		rD = !trans.rightDir;
		changeTransDirection(rAT, sX, sY, pX, pY, rD);
	}
	
	trans.position.x += trans.speedX;
}

function changeTransDirection(rAT, sX, sY, pX, pY, arrD){
	stage.removeChild(trans);
	if(arrD){
		trans = createObject(rST, sX, sY, pX, pY, arrD);
		stage.addChild(trans);
	}else{
		trans = createObject(lST, sX, sY, pX, pY, arrD);
		stage.addChild(trans);
	}
}

function animateScarab(){
	collideBox(scarab, scInitY);
	
	if(scarab.position.y + scarab.speedY >= scYS)
		scarab.speedY = scInitY;
		
	if((scarab.position.x + (0.5 * scarab.width) + scarab.speedX >= renderer.width) || (scarab.position.x + scarab.speedX  < 0)){
		console.log('change');
		sX = scarab.speedX * -1;
		sY = scarab.speedY; 
		pX = scarab.position.x;
		pY = scarab.position.y; 
		rD = !scarab.rightDir;
		changeScarabDirection(rST, sX, sY, pX, pY, rD);
	}
		
	scarab.speedY -= alpha;
	scarab.position.x += scarab.speedX;
	scarab.position.y -= scarab.speedY;
}

function changeArcheologistDirection(rAT, sX, sY, pX, pY, arrD){
	stage.removeChild(archeologist);
	if(arrD){
		archeologist = createObject(rAT, sX, sY, pX, pY, arrD);
		stage.addChild(archeologist);
	}else{
		archeologist = createObject(lAT, sX, sY, pX, pY, arrD);
		stage.addChild(archeologist);
	}
}

function changeScarabDirection(rST, sX, sY, pX, pY, rD){
	stage.removeChild(scarab);	
	if(!rD){
		scarab = createObject(lST, sX, sY, pX, pY, rD);
		stage.addChild(scarab);
	}else{
		scarab = createObject(rST, sX, sY, pX, pY, rD);
		stage.addChild(scarab);
	}	
}

var BrickObj = function(x,y){
	brickSprite = new PIXI.Sprite(brickTexture);
	brickSprite.interactive = true;
	brickSprite.position.x = x;
	brickSprite.position.y = y;
	brickSprite.anchor.x = 0.5;
	brickSprite.anchor.y = 0.5;
	brickSprite.click = hideBrick;
	stage.addChild(brickSprite);
	return brickSprite;
};

function createBrick(mouseData){
	var pos = mouseData.getLocalPosition(stage);	
	idx = findBrickIndex(pos.x, pos.y);
	len = brickPos.length;
	
	col = willCollide(pos.x, pos.y);
	
	if(idx == -1 && len != 7 && !col){
		var newBrick = BrickObj(pos.x, pos.y);
		brickPos.push(newBrick);
		brickCounter = brickCounter + 1;
		redrawCounter();
	}
}

function hideBrick(mouseData){
	var pos = mouseData.getLocalPosition(stage);
	idx = findBrickIndex(pos.x, pos.y);
	
	br = brickPos[idx];
	stage.removeChild(brickPos[idx]);
    brickPos.splice(idx, 1);
	brickCounter = brickCounter - 1;
	redrawCounter();
}

function redrawCounter(){
	stage.removeChild(counterObj);
	
	counterObj = createSimpleObject(counterArr[counterArr.length - brickCounter - 1], renderer.width - 50, 50);
	stage.addChild(counterObj);
}

function findBrickIndex(x, y){
	for(var i = 0; i < brickPos.length; i++){
		brick = brickPos[i];
		xStart = brick.position.x - (0.5 * brick.width);
		xEnd = brick.position.x + (0.5 * brick.width);
		yStart = brick.position.y - (0.5 * brick.height);
		yEnd = brick.position.y + (0.5 * brick.height);		
		
		if(xStart <= x && x <= xEnd && yStart <= y && y <= yEnd){
			return i;
		}
	}
	return -1;
}

function willCollide(x, y){
	deltaY = Math.abs(archeologist.position.y - y);
	deltaX = Math.abs(archeologist.position.x - x);
		
	diffH = (archeologist.height + 40) / 4;
	diffW = (archeologist.width + 40) / 4;
	
	if(deltaY <= diffH && deltaX <= diffW){
		return true;
	}
	
	return false;
}

function collideBox(obj, initY){
	var deltaY, deltaX;
	var brick;
	var diffH, diffW;
	var collides = false;
	
	for(var i = 0; i < brickPos.length; i++){
		brick = brickPos[i];
				
		deltaY = Math.abs(obj.position.y - brick.position.y);
		deltaX = Math.abs(obj.position.x - brick.position.x);
		
		diffH = (obj.height + brick.height) / 2;
		diffW = (obj.width + brick.width) / 2;
		
		if(deltaY <= diffH && deltaX <= diffW){
			collides = true;
			break;
		}
	}
	
	if(collides){
		if(Math.abs(deltaX - diffW) < Math.abs(deltaY - diffH)){
			//vertical case
			if(obj.position.y <= brick.position.y){
				//top --> special case
				obj.speedY = initY;
			}else{
				//fall down case
				obj.speedY = -3;
			}
		}else{
			//fall down case
			obj.speedY = -3;
		}
	}
}

function die(){
	deltaY = Math.abs(archeologist.position.y - scarab.position.y);
	deltaX = Math.abs(archeologist.position.x - scarab.position.x);
		
	diffH = (archeologist.height + scarab.height) / 4;
	diffW = (archeologist.width + scarab.width) / 4;
		
	if(deltaY <= diffH && deltaX <= diffW){
		return true;
	}
	return false;
}

function win(){
	deltaY = Math.abs(archeologist.position.y - goldDust.position.y);
	deltaX = Math.abs(archeologist.position.x - goldDust.position.x);
		
	diffH = (archeologist.height + goldDust.height) / 5;
	diffW = (archeologist.width + goldDust.width) / 5;
		
	if(deltaY <= diffH && deltaX <= diffW){
		return true;
	}
	return false;
}