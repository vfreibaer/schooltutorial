function onYouTubePlayerReady(playerId) {
	var ytplayer = document.getElementById(playerId);
	ytplayer.addEventListener("onStateChange", "onYTPlayerStateChange"+playerId);
	setTimeout("onYTPlayerInit"+playerId+"()",1);
} 
