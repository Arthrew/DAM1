var audio1 = new Audio('audios/trap.mp3');
var audio2 = new Audio('audios/rap.mp3');
var audio3 = new Audio('audios/reggaeton.mp3');
var audio4 = new Audio('audios/rock.mp3');
var audio5 = new Audio('audios/electro.mp3');
var audio6 = new Audio('audios/frances.mp3');
var audio7 = new Audio('audios/pop.mp3');
var audio8 = new Audio('audios/samba.mp3');

function mostrar1(){
	document.getElementById('uno').style.display='block';
	document.getElementById('dos').style.display='none';
	document.getElementById('tres').style.display='none';
	document.getElementById('cuatro').style.display='none';
	document.getElementById('cinco').style.display='none';
	document.getElementById('seis').style.display='none';
	document.getElementById('siete').style.display='none';
	document.getElementById('ocho').style.display='none';
	audio1.play();
	audio2.pause();
	audio3.pause();
	audio4.pause();
	audio5.pause();
	audio6.pause();
	audio7.pause();
	audio8.pause();
}

function mostrar2(){
	document.getElementById('dos').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('tres').style.display='none';
	document.getElementById('cuatro').style.display='none';
	document.getElementById('cinco').style.display='none';
	document.getElementById('seis').style.display='none';
	document.getElementById('siete').style.display='none';
	document.getElementById('ocho').style.display='none';
	audio1.pause();
	audio2.play();
	audio3.pause();
	audio4.pause();
	audio5.pause();
	audio6.pause();
	audio7.pause();
	audio8.pause();
}

function mostrar3(){
	document.getElementById('tres').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('dos').style.display='none';
	document.getElementById('cuatro').style.display='none';
	document.getElementById('cinco').style.display='none';
	document.getElementById('seis').style.display='none';
	document.getElementById('siete').style.display='none';
	document.getElementById('ocho').style.display='none';
	audio1.pause();
	audio2.pause();
	audio3.play();
	audio4.pause();
	audio5.pause();
	audio6.pause();
	audio7.pause();
	audio8.pause();
}

function mostrar4(){
	document.getElementById('cuatro').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('dos').style.display='none';
	document.getElementById('dos').style.display='none';
	document.getElementById('cinco').style.display='none';
	document.getElementById('seis').style.display='none';
	document.getElementById('siete').style.display='none';
	document.getElementById('ocho').style.display='none';
	audio1.pause();
	audio2.pause();
	audio3.pause();
	audio4.play();
	audio5.pause();
	audio6.pause();
	audio7.pause();
	audio8.pause();
}
function mostrar5(){
	document.getElementById('cinco').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('dos').style.display='none';
	document.getElementById('tres').style.display='none';
	document.getElementById('cuatro').style.display='none';
	document.getElementById('seis').style.display='none';
	document.getElementById('siete').style.display='none';
	document.getElementById('ocho').style.display='none';
	audio1.pause();
	audio2.pause();
	audio3.pause();
	audio4.pause();
	audio5.play();
	audio6.pause();
	audio7.pause();
	audio8.pause();
}

function mostrar6(){
	document.getElementById('seis').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('dos').style.display='none';
	document.getElementById('tres').style.display='none';
	document.getElementById('cuatro').style.display='none';
	document.getElementById('cinco').style.display='none';
	document.getElementById('siete').style.display='none';
	document.getElementById('ocho').style.display='none';
	audio1.pause();
	audio2.pause();
	audio3.pause();
	audio4.pause();
	audio5.pause();
	audio6.play();
	audio7.pause();
	audio8.pause();
}

function mostrar7(){
	document.getElementById('siete').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('dos').style.display='none';
	document.getElementById('tres').style.display='none';
	document.getElementById('cuatro').style.display='none';
	document.getElementById('cinco').style.display='none';
	document.getElementById('seis').style.display='none';
	document.getElementById('ocho').style.display='none';
	audio1.pause();
	audio2.pause();
	audio3.pause();
	audio4.pause();
	audio5.pause();
	audio6.pause();
	audio7.play();
	audio8.pause();
}

function mostrar8(){
	document.getElementById('ocho').style.display='block';
	document.getElementById('uno').style.display='none';
	document.getElementById('dos').style.display='none';
	document.getElementById('tres').style.display='none';
	document.getElementById('cuatro').style.display='none';
	document.getElementById('cinco').style.display='none';
	document.getElementById('seis').style.display='none';
	document.getElementById('siete').style.display='none';
	audio1.pause();
	audio2.pause();
	audio3.pause();
	audio4.pause();
	audio5.pause();
	audio6.pause();
	audio7.pause();
	audio8.play();
}