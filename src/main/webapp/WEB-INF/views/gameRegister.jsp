<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/gameRegister.css">
<title>게임등록</title>
</head>
<body>
	<div class="container h-100vh">
	<div class="row row h-100 align-items-center justify-content-centerr">
		<div class="col align-self-cente ">
			<div class="card">
				<div class="card-header text-center display-4">
					게임등록
				</div>
				<div class="card-body">
					<form action="gameInsert" method="post" enctype="multipart/form-data">
						<div class="form-row">
							<div class="form-group col-md-2">
								<label for="g_id">이름</label>
								<input type="text" id="g_name" name=" g_name" placeholder="이름을 입력하세요.">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="g_content">설명</label>
								<textarea id="g_content" name="g_content" rows="5" cols="42"
								placeholder="설명을 입력하세요."></textarea>
							</div>
						</div>
						<button type="submit" class="btn btn-primary btn-lg btn-block">등록하기</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>