<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	href="${pageContext.request.contextPath }/resources/css/header.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/js/header.js"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a href="index" class="navbar-brand">PGC<b>Board</b></a>
	<button type="button" class="navbar-toggler" data-toggle="collapse"
		data-target="#navbarCollapse">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- Collection of nav links, forms, and other content for toggling -->
	<div id="navbarCollapse"
		class="collapse navbar-collapse justify-content-start">
		<div class="navbar-nav">
			<a href="index" class="nav-item nav-link">Home</a> <a
				href="productPage" class="nav-item nav-link">Games</a>
		</div>

		<div class="navbar-nav action-buttons ml-auto">
			<%
				if (null == session || null == session.getAttribute("u_uid")) {
					out.print(
							"<a href='#' data-toggle='dropdown' class='nav-item nav-link dropdown-toggle mr-3'>Login</a> <div class='dropdown-menu login-form'> <form action='signinCheck' method='post'> <div class='form-group'> <label>UserID</label> <input type='text' class='form-control' required='required' id='id' name='id'> </div> <div class='form-group'> <div class='clearfix'> <label>Password</label> </div> <input type='password' class='form-control' required='required' id='pw' name='pw'> </div> <input type='submit' class='btn btn-primary btn-block' value='Login'> </form> </div> <a href='signUp' class='btn btn-primary'>Sign Up</a>");
				} else {
					if (session.getAttribute("u_mode").equals(1)) {
						out.print("<a href='admin' class='nav-item nav-link'>관리자</a>");
					} else {
						out.print(
								"<a onclick='loadMyPage(" + session.getAttribute("u_id") + ")' class='nav-item nav-link'>My Page</a>");
					}

					out.print("<a href='signOut' class='btn btn-primary'>Sign Out</a>");
				}
			%>
		</div>
	</div>
</nav>
</head>