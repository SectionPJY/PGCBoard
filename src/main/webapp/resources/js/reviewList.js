function reviewDelete(r_id) {
	console.log(r_id);

	$.ajax({
		type : "post",
		url : "http://localhost:8080/ex/reviewDelete",
		data : {
			r_id : r_id
		},
		success : function(data, status) {
			alert("삭제되었습니다.");

			window.location.reload();
		},
		error : function(status) {
			alert("삭제에 실패하였습니다.")

			return false;
		}
	});
};