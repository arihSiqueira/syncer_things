/*
 * Js to control some behavior of page
 */



function openMyChords(id){
	for (var i=0; i<songs.length;i++){
		if (id == songs[i]['id']){
			$("#cifra").html(songs[i]['letraMusica']);
			$("#myCifra").modal('show');
		}
	}
}