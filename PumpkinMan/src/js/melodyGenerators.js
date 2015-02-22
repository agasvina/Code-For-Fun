var current_melody = [];
var user_melody = [];

var NOTES_ARRAY;

var melodyGenerator;
var parallel;

function playSeqLevel(notes,len){
	parallel = false;
	NOTES_ARRAY = notes;

	melodyGenerator = function(){
		for(var i=0; i<len; i++){
			var ran = Math.floor((Math.random() * NOTES_ARRAY.length) + 1);
			var current_note = NOTES_ARRAY[ran-1];
			current_melody[current_melody.length] = {note:current_note,len:"4"};
		}
	}

	playRandomNote();
}

function playParLevel(notes){
	parallel = true;
	NOTES_ARRAY = notes;

	melodyGenerator = function(){
		var ran1=0;
		var ran2=0;
		while(ran1 == ran2){
			ran1 = Math.floor((Math.random() * NOTES_ARRAY.length) + 1);
			ran2 = Math.floor((Math.random() * NOTES_ARRAY.length) + 1);
		}
		note1 = NOTES_ARRAY[ran1-1];
		note2 = NOTES_ARRAY[ran2-1];
		current_melody = [{note:note1,len:"0"},{note:note2,len:"0"}];
	}

	playRandomNote();
}

function playRandomNote(){
	showMessage("Get ready!","green", 2000);
	current_melody = [];
    user_melody = [];
	melodyGenerator();
	setTimeout(function(){playMelody(current_melody,false); enableKeyboard(true)},2000);
}

function playUserAnswer(note){
    playNote(note);
	if(parallel){
		for(var i=0; i<user_melody.length; i++){
			playNote(user_melody[i]);
		}
	}

	$("#"+note+" > .key").unbind('mouseenter mouseleave');
	$("#"+note+" > .key").animate({'opacity':0},5);
	
	user_melody[user_melody.length] = note;
	
	if(user_melody.length == current_melody.length){
		checkUserAnswer();
	}
}

function checkUserAnswer(){
	disableKeyboard();
	
	var guess = true;
	
	if(parallel){
		u1 = user_melody[0];
		u2 = user_melody[1];
		c1 = current_melody[0].note;
		c2 = current_melody[1].note;
		if(!(((u1==c1)&&(u2==c2))||((u1==c2)&&(u2==c1)))) guess = false;
	}else{
		for(var i = 0; i < current_melody.length; i++){
			if(current_melody[i].note != user_melody[i]) guess = false;
		}
	}
	
    if(guess == true) {
        //if already 10, move to the next level
        score++;
		showMessage("Correct!","blue");
		jump();
    }else {
		if(score>0){
			jumpBack();
		}
        score = (score > 0) ? score-1 : 0;
		showMessage("Wrong!","red");
    }

	showUserScore();
	
	if(score == MAX_SCORE){
		//alert("Next level");
		if(MAX_LEVEL == CUR_LEVEL){
			MAX_LEVEL++;
		}
		showEndLevel();
	}
	else {
		setTimeout(function(){playRandomNote()},1000);
	}
}