<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="${pageContext.request.contextPath }/resources/js/gameInfo.js"></script>
<title>Game Info Page</title>
</head>
<c:forEach items="${game}" var="GameDTO">
	<body>
		<form action="updateGame" method="post">
			ID : <input type="text" placeholder=${GameDTO.g_id }
				value=${GameDTO.g_id } id="g_id" name="g_id" readonly> <br>
			이름 : <input type="text" id="g_name" name="g_name"
				value="${GameDTO.g_name }"> <br> 설명 : <br>
			<textarea id="g_content" name="g_content" rows="5" cols="30">${GameDTO.g_content }</textarea>
			<br>
			<br> <input type="button" value="취소" onclick="cancelBtn()"> <input type=submit value="수정">
		</form>
	</body>
</c:forEach>
</html>