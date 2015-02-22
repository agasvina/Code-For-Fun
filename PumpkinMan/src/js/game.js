var MAX_LEVEL = 1;
var CUR_LEVEL = 1;

$( document ).ready(function() {
	showMap();
	$(".levelPumpkin").hover(function(){
		$(this).animate({'opacity':1},200);
	}, function(){
		$(this).animate({'opacity':0.7},200);
	});
	$(".levelPumpkin").click(function(){
		selectLevel($(this).attr("level"));
	});
});

function showMap(){
    $("#levels").show();
    $("#game").hide();
	$("#levelEnd").hide();
	
	$(".levelPumpkin").each(function() {
		var lvl = $(this).attr("level");
		if(lvl>MAX_LEVEL){
			$(this).hide();
		} else {
			$(this).show();
		}
	});
	
	var mapBg;
	if(MAX_LEVEL == 1){
		mapBg = "Level_01.png";
	} else if(MAX_LEVEL == 2){
		mapBg = "Level_02.png";
	} else if(MAX_LEVEL == 3){
		mapBg = "Level_03.png";
	} else if(MAX_LEVEL == 4){
		mapBg = "Level_04.png";
	} else {
		mapBg = "Level_05.png";
	}
	
	mapBg = "assets/images/map/"+mapBg;
	
	$("#mapImage").attr("src", mapBg);
}

function prepareBackGround(lvl){
	
	var backImg = "level"+lvl+".jpg";
	
	backImg = "assets/images/backgrounds/" + backImg;
	
	$("#backLevel").attr("src", backImg);
}

function selectLevel(lvl){
	CUR_LEVEL = lvl;
    $("#levels").hide();
    $("#game").show();
	
$('#nextManuscript').unbind('click');
	prepareBackGround(lvl);
	resetPumpkin();
	prepareCanvas(document.getElementById("canvasDiv"), 1280, 220);
	var intro;
	var notes;

	if(lvl == 1){
		intro = [{note: "C2", len:"8"}, {note: "E2", len:"8"}, 
			{note: "G2", len:"8d"}, {note: "G2", len:"16"}, 
			{note: "C2", len:"2"}];
		notes = ["C2","E2","G2"];
	}
	
	if(lvl == 2){
		intro = [{note: "C2", len:"8"}, {note: "A2", len:"8"}, 
			{note: "F2", len:"8"}, {note: "G2", len:"8"}, 
			{note: "D2", len:"8"}, {note: "F2", len:"8"},
			{note: "G2", len:"8"}, {note: "A2", len:"8"}];
		notes = ["C2","D2","F2","G2","A2"];
	}
	
	if(lvl == 3){
		intro = [{note: "C2", len:"8"}, {note: "E2", len:"8"},
			{note: "B2", len:"8"}, {note: "G2", len:"8"},
			{note: "A2", len:"8"}, {note: "D2", len:"8"},
			{note: "F2", len:"8"}, {note: "E2", len:"8"},
			{note: "C2", len:"1"}];
		notes = ["C2","D2","E2","F2","G2","A2","B2"];
	}

	if(lvl == 4){
		intro = [{note: "C2", len:"8"},{note: "G2", len:"8t"},
			{note: "G2", len:"8t"}, {note: "G2", len:"8t"},
			{note: "C2", len:"8"}, {note: "G2", len:"8t"},
			{note: "G2", len:"8t"}, {note: "G2", len:"8t"},
			{note: "C2", len:"8"}, {note: "G2", len:"8t"},
			{note: "G2", len:"8t"}, {note: "G2", len:"8t"},
			{note: "Gs2", len:"8"}, {note: "Gs2", len:"8"}];
		notes = ["C2","Cs2","D2","Ds2","E2","F2","Fs2","G2","Gs2","A2","As2","B2"];
	}

	if(lvl == 5){
		intro = [{note: "E2", len:"8"}, {note: "B2", len:"4d"},
		{note: "D2", len:"8"}, {note: "A2", len:"4d"},
		{note: "E2", len:"8"}, {note: "B2", len:"8"},
		{note: "C2", len:"8"}, {note: "G2", len:"2"}]
		notes = ["C2","D2","E2","F2","G2","A2","B2"];
	}

	if(lvl == 6){
		intro = [{note: "D2", len:"8t"}, {note: "G2", len:"8t"},
	{note: "A2", len:"4d"}, {note: "G2", len:"8t"},
	{note: "F2", len:"8t"}, {note: "E2", len:"4d"},
	{note: "D2", len:"8t"}, {note: "E2", len:"8t"},
	{note: "F2", len:"4d"}, {note: "E2", len:"8t"},
	{note: "F2", len:"8t"}, {note: "G2", len:"2"}];
	notes = ["C2","D2","E2","F2","G2","A2","B2"];
	}
	
	if(lvl == 7){
		intro = [{note: "C2", len:"0"}, {note: "E2", len:"8"},
		{note: "F2", len:"0"}, {note: "A2", len:"8"}, 
		{note: "D2", len:"0"}, {note: "F2", len:"8d"},
		{note: "G2", len:"0"}, {note: "B2", len:"8"},
		{note: "G2", len:"0"}, {note: "B2", len:"8"},
		{note: "G2", len:"0"}, {note: "B2", len:"16"},
		{note: "G2", len:"0"}, {note: "B2", len:"8"},
		{note: "G2", len:"0"}, {note: "B2", len:"8"},
		{note: "C2", len:"0"}, {note: "E2", len:"8"},
		{note: "F2", len:"0"}, {note: "A2", len:"8"}, 
		{note: "D2", len:"0"}, {note: "F2", len:"8d"},
		{note: "G2", len:"0"}, {note: "B2", len:"8"},
		{note: "G2", len:"0"}, {note: "B2", len:"8"},
		{note: "G2", len:"0"}, {note: "B2", len:"16"},
		{note: "G2", len:"0"}, {note: "B2", len:"8"},
		{note: "G2", len:"0"}, {note: "B2", len:"8"}];
		notes = ["C2","D2","E2","F2","G2","A2","B2"];
	}
	
	
	playMelody(intro);
	
	var timeout = getMelodyLength(intro);
	if(lvl<5){
		setTimeout(function(){playSeqLevel(notes,1)},timeout);
	}
	if(lvl==5){
		setTimeout(function(){playSeqLevel(notes,2)},timeout);
	}
	if(lvl==6){
		setTimeout(function(){playSeqLevel(notes,3)},timeout);
	}

	if(lvl==7){
		setTimeout(function(){playParLevel(notes)},timeout);
	}
	
	score = 0;
}

function playAndShow(note,show){
	show = typeof show !== 'undefined' ? show : true;
	playNote(note);
	if(show == true){
		showNote(note);
	}
}

function showNote(note){
		selector = "#"+note+" > .key";
        $(selector).animate({'opacity':0},50);
        $(selector).animate({'opacity':1},50);
}

function playMelody(melody, show){
	show = typeof show !== 'undefined' ? show : true;
	var curTime = 0;
	for (var i = 0; i < melody.length; i++) {
		(function (i) {
			var n = melody[i];
			ms = lenToMS(n.len);
			setTimeout(function(){playAndShow(n.note,show)},curTime);
			curTime += ms;
		})(i);
	}
}

function lenToMS(len){
	if(len == 0) return 0;
	var BPM = 120;
	var barLen = ((60*1000)/BPM)*4;
	var main = parseInt(len);
	var ms = barLen/main;
	if(len.indexOf("d") > -1) ms *= 1.5;
	if(len.indexOf("t") > -1) ms /= 3;
	return ms;
}

function getMelodyLength(melody){
	var sum = 0;
	for (var i = 0; i < melody.length; i++) {
		var n = melody[i];
		sum += lenToMS(n.len);
	}
	return sum;
}
