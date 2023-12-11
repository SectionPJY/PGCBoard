function loadMyPage(u_id) {
	console.log(u_id);
	const url = "http://localhost:8080/ex/myPage?u_id=" + u_id;
	
	window.location.href = url;
};