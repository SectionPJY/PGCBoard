<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info Page</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	function cancelBtn() {
		window.close();
	}

	function ageSelect(u_age) {
		switch (u_age) {
		case "17":
			console.log(u_age);
			$("#u_age").val("17").prop("selected", true);
			break;
		case "18":
			console.log(u_age);
			$("#u_age").val("18").prop("selected", true);
			break;
		case "19":
			console.log(u_age);
			$("#u_age").val("19").prop("selected", true);
			break;
		case "20":
			console.log(u_age);
			$("#u_age").val("20").prop("selected", true);
			break;
		case "21":
			console.log(u_age);
			$("#u_age").val("21").prop("selected", true);
			break;
		case "22":
			console.log(u_age);
			$("#u_age").val("22").prop("selected", true);
			break;
		case "23":
			console.log(u_age);
			$("#u_age").val("23").prop("selected", true);
			break;
		}
	}
</script>
</head>
<c:forEach items="${userInfo}" var="UserDTO">
	<body onload="ageSelect('${UserDTO.u_age}')">
		<form action="updateUser" method="post">
			ID : <input type="text" placeholder=${UserDTO.u_uid }
				value=${UserDTO.u_uid } id="u_uid" name="u_uid" readonly> <br>
			PW : <input type="password" value="${UserDTO.u_pw }" id="u_pw"
				name="u_pw"> <br> 이름 : <input type="text"
				value="${UserDTO.u_name }" id="u_name" name="u_name"> 또래 : <select
				id="u_age" name="u_age">
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
			</select> 또래 <br> Phone : <input type="text" value="${UserDTO.u_phone }"
				id="u_phone" name="u_phone"> <br> <br> <input
				type="button" onclick="cancelBtn()" value="취소"> <input
				type="submit" value="수정">
		</form>
	</body>
</c:forEach>
</html>