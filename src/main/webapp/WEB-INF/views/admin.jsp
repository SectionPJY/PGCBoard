<%--
  Created by IntelliJ IDEA.
  User: sectionsmacbookair
  Date: 2022/10/12
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
<%@ include file="adminHeader.jsp"%>
<script type="text/javascript">
	function userAccept(u_id) {
		console.log(u_id);

		$.ajax({
			type : "post",
			url : "http://localhost:8080/ex/userAccept",
			data : {
				u_id : u_id
			},
			success : function(data, status) {
				alert("승인되었습니다.");

				window.location.reload();
			},
			error : function(status) {
				alert("승인에 실패하였습니다.")

				return false;
			}
		});
	};

	function userRej(u_id) {
		console.log(u_id);

		$.ajax({
			type : "post",
			url : "http://localhost:8080/ex/userRej",
			data : {
				u_id : u_id
			},
			success : function(data, status) {
				alert("강퇴조치 되었습니다.");

				window.location.reload();
			},
			error : function(status) {
				alert("강퇴조치에 실패하였습니다.");

				return false;
			}
		});
	};

	function userRes(u_id) {
		console.log(u_id);

		$.ajax({
			type : "post",
			url : "http://localhost:8080/ex/userAccept",
			data : {
				u_id : u_id
			},
			success : function(data, status) {
				alert("복구조치 되었습니다.");

				window.location.reload();
			},
			error : function(status) {
				alert("복구에 실패하였습니다.");

				return false;
			}
		});
	};

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
	}
</script>
<title>관리자 페이지</title>
</head>
<body>
	<h1>Admin Page</h1>
	<hr>
</body>
</html>
