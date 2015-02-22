/**
 * Created by Think on 31/10/2014.
 */
var score = 0;
var MAX_SCORE = 10;




$( document ).ready(function() {
	$( document ).ready(function() {
		$("#backMap").click(function(){
			showMap();
		});
	});

	$("#levelEnd").hide();
});


function showEndLevel(){
	$("#mapManuscript").click(function(){
		showMap();
	});
	$("#nextManuscript").click(function(){
$("#levelEnd").hide();
		selectLevel(parseInt(CUR_LEVEL) + 1);
	});
	$("#levelEnd").show();
}

function enableKeyboard(){
	$(".key").each(function() {
		var note = $(this).parent().attr("id");
		for (var i = 0; i < NOTES_ARRAY.length; i++) {
		if(note == NOTES_ARRAY[i]){
			$(this).click(function() {
        var parent = $(this).parent();
        playUserAnswer(parent.attr("id"));
		});

			$(this).hover(function(){
				$(this).animate({'opacity':0},1);
			}, function(){
				$(this).animate({'opacity':1},1);
			});
		}
	}
	});
}

function disableKeyboard(){
	$('.key').attr('onclick','').unbind('click');
	$('.key').unbind('mouseenter mouseleave');
	$(".key").animate({'opacity':1},500);
}

function showMessage(text,color,len){
		len = typeof len !== 'undefined' ? len : 1000;
        $("#feedbackString").text(text);
        $("#feedbackString").css('color', color);
        $("#feedbackString").css('font-size', '200px');
        $("#feedbackString").show();
        $("#feedbackString").hide(len);
}

function showUserScore(){
	$("#scoreString").text(score + "/" + MAX_SCORE);
	$("#scoreString").css('font-size', '50px');
	$("#scoreDiv").show();
}