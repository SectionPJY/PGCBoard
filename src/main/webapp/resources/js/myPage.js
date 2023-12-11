function userInfo(u_id) {
		console.log(u_id);
		
		var width = 700;
		var height = 400;
		var positionX = (window.screen.width / 2) - (width / 2);
        var positionY = (window.screen.height / 2) - (height / 2);
        
		window.open(
				"userInfo?u_id=" + u_id, 	// 링크
				"userInfo",	// 새 창 아이디
				"width=" + width +
				", height=" + height +
				", top=" + positionY +
				", left=" + positionX);
		
		return false;
	};
	
function returnGame(r_uid, r_gid) {
	
	$.ajax({
		type : "post",
		url : "http://localhost:8080/ex/returnGameUser",
		data : {
			r_uid : r_uid,
			r_gid : r_gid
			
		},
		success : function(data, status) {
			alert("반납처리 되었습니다.");
			
			window.location.reload();
		},
		error : function(status) {
			alert("반납처리에 실패하였습니다.");
			
			return false;
		}
	});
}