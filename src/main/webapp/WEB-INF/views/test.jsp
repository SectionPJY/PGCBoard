<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/test.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<a href='#' data-toggle='dropdown'
		class='nav-item nav-link dropdown-toggle mr-3'>Login</a>
	<div class='dropdown-menu login-form'>
		<form action='signinCheck' method='post'>
			<div class='form-group'>
				<label>UserID</label>
				<input type='text' class='form-control' required='required' id='id' name='id'>
			</div>
			<div class='form-group'>
				<div class='clearfix'>
					<label>Password</label>
				</div>
				<input type='password' class='form-control' required='required' id='pw' name='pw'>
			</div>
			<input type='submit' class='btn btn-primary btn-block' value='Login'>
		</form>
	</div>
</body>
</html>