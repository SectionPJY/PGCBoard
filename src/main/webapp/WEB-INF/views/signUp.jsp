<%--
  Created by IntelliJ IDEA.
  User: sectionsmacbookair
  Date: 2022/10/12
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="header.jsp"%>
<html>
<head>
<script src="${pageContext.request.contextPath }/resources/js/signUp.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/signUp.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css.map">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js">
<title>회원가입</title>
</head>
<body>
	<div class="form">

		<h1>회원가입</h1>

		<form action="signUpCheck" method="post" accept-charset="utf-8">
			<input type="text" name="u_uid" placeholder="아이디를 입력해주세요."><br>
			<input type="password" id="u_pw" name="u_pw"
				placeholder="비밀번호를 입력해주세요."><br> <input type="password"
				id="pw2" name="pw2" placeholder="비밀번호를 다시 입력해주세요."
				onchange="checkPw()"><br> <span id="pwCheckMsg"></span><br>
			<input type="text" id="u_name" name="u_name"
				placeholder="이름을 입력해주세요."><br> <select id="u_age"
				name="u_age">
				<option value="17">17또래</option>
				<option value="18">18또래</option>
				<option value="19">19또래</option>
				<option value="20">20또래</option>
				<option value="21">21또래</option>
				<option value="22">22또래</option>
				<option value="23" selected>23또래</option>
			</select> <br> <input type="text" id="u_phone" name="u_phone"
				placeholder="핸드폰 번호를 입력해주세요.(- 제외)" maxlength="11"> <input
				type="submit" value="회원가입"> <br> <br> <br>
			<h4>
				이미 회원가입을 하셨나요?<br> <a href="index">로그인</a>
			</h4>
		</form>
	</div>
</body>
</html>
