<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/myPage.css">
<script
	src="${pageContext.request.contextPath }/resources/js/myPage.js"></script>
<title>마이페이지</title>
</head>
<body>
<c:forEach items="${userInfo }" var="UserInfo">
<section style="background-color: #fff;">
  <div class="container py-5">
    <div class="row">
      <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
            <img src="${pageContext.request.contextPath }/resources/assets/img/user.png" alt="avatar"
              class="rounded-circle img-fluid" style="width: 150px;">
            <h5 class="my-3">${UserInfo.u_name }</h5>
            <p class="text-muted mb-1">${UserInfo.u_age }또래</p>
            <div class="d-flex justify-content-center mb-2">
              <button type="button" class="btn btn-outline-primary ms-1" onclick="userInfo(${UserInfo.u_id })">정보수정</button>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-8">
        <div class="card mb-4">
          <div class="card-body">
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">아이디</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${UserInfo.u_uid }</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">이름</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${UserInfo.u_name }</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">핸드폰</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${UserInfo.u_phone }</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">또래</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${UserInfo.u_age }또래</p>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <div class="card mb-4 mb-md-0">
              <div class="card-body">
                <p class="mb-4"><span class="text-primary font-italic me-1">대여</span> 내역</p>
                <table id="example" class="table table-striped table-bordered" cellspacing="0">
					<thead>
						<tr>
							<th>게임명</th>
							<th>대여일</th>
							<th>비고</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${rentList }" var="RentList">
						<tr>
							<td>${RentList.g_name }</td>
							<td>${RentList.r_date }</td>
							<td>
								<input type="button" value="반납하기" onclick="returnGame('${RentList.r_uid }', '${RentList.r_gid }')">
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</c:forEach>
</body>
</html>