var audio1 = new Audio('audio/taburete.mp3');
var audio2 = new Audio('audio/Gods Plan.mp3');
var audio3 = new Audio('audio/No Love.mp3');
var audio4 = new Audio('audio/Amanece.mp3');

function mostrar1(){
	document.getElementById('uno').style.display='block';
	document.getElementById('dos').style.display='none';
	document.getElementById('tres').style.display='none';
	document.getElementById('cuatro').style.display='none';
	
	audio1.play();
	audio2.pause();
	audio3.pause();
	audio4.pause();
}

function mostrar2(){
	document.getElementById('dos').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('tres').style.display='none';
	document.getElementById('cuatro').style.display='none';
	
	audio1.pause();
	audio2.play();
	audio3.pause();
	audio4.pause();
}

function mostrar3(){
	document.getElementById('tres').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('dos').style.display='none';
	document.getElementById('cuatro').style.display='none';
	
	audio1.pause();
	audio2.pause();
	audio3.play();
	audio4.pause();
}

function mostrar4(){
	document.getElementById('cuatro').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('dos').style.display='none';
	document.getElementById('dos').style.display='none';
	
	audio1.pause();
	audio2.pause();
	audio3.pause();
	audio4.play();
}