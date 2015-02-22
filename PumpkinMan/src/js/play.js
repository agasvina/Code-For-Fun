$( document ).ready(function() {
	createjs.Sound.registerSound("assets/sounds/C2.mp3","C2", 10);
	createjs.Sound.registerSound("assets/sounds/Cs2.mp3","Cs2", 10);
	createjs.Sound.registerSound("assets/sounds/D2.mp3","D2", 10);
	createjs.Sound.registerSound("assets/sounds/Ds2.mp3","Ds2", 10);
	createjs.Sound.registerSound("assets/sounds/E2.mp3","E2", 10);
	createjs.Sound.registerSound("assets/sounds/F2.mp3","F2", 10);
	createjs.Sound.registerSound("assets/sounds/Fs2.mp3","Fs2", 10);
	createjs.Sound.registerSound("assets/sounds/G2.mp3","G2", 10);
	createjs.Sound.registerSound("assets/sounds/Gs2.mp3","Gs2", 10);
	createjs.Sound.registerSound("assets/sounds/A2.mp3","A2", 10);
	createjs.Sound.registerSound("assets/sounds/As2.mp3","As2", 10);
	createjs.Sound.registerSound("assets/sounds/B2.mp3","B2", 10);
	createjs.Sound.registerSound("assets/sounds/beat.mp3","beat", 10);
	createjs.Sound.setVolume(0.5);
});

function playNote(note){
	//createjs.Sound.stop();
	createjs.Sound.play(note);
}