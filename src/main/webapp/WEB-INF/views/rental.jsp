<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여페이지</title>
<script>
	function cancelBtn() {
		window.close();
	};
</script>
</head>
<body>
	<form action="rentalInsert" method="post">
		<h4>대여확인</h4>
		대여자: ${userName } <br>
		게임명: ${gameName } <br>
		대여사유<br>
		<textarea id="r_content" name="r_content" rows="5" cols="20"></textarea> <br>
		<input type="hidden" id="r_uid" name="r_uid" value="${userId }">
		<input type="hidden" id="r_gid" name="r_gid" value="${gameId }">

		<input type="button" value="취소하기" onclick="cancelBtn()">
		<input type="submit" value="대여하기">
	</form>
</body>
</html>