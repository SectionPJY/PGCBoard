<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath }/resources/js/userList.js"></script>
<title>회원목록</title>
</head>
<body>

	<div class="container">
		<h1>등록회원</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">이름</th>
					<th scope="col">ID</th>
					<th scope="col">또래</th>
					<th scope="col">비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${uList }" var="UserList">
				<tr>
					<td>${UserList.u_name }</td>
					<td>${UserList.u_uid }</td>
					<td>${UserList.u_age }</td>
					<td><input type="button" value="조회" onclick="userInfo(${UserList.u_id})">
						<input type="button" value="삭제" onclick="userRej('${UserList.u_uid}')"></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:if test="${curPageNum > 10 }">
				<li class="page-item disabled">
      				<a class="page-link" href="reviewList?page=${startNum - 1 }">Previous</a>
    			</li>
			</c:if>
			
			<c:if test="${lastPageNumUser < lastNum }">
				<c:forEach begin="${startNum }" end="${lastPageNumUser }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumUser }">
							<li class="page-item">${i }</li>
						</c:when>
						<c:when test="${i == curPageNum }">
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="#">${i }</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="reviewList?page=${i }">
									${i }
								</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			
			<c:if test="${lastPageNumUser > lastNum }">
				<c:forEach begin="${startNum }" end="${lastNum }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumUser }">
							<li class="page-item">${i }</li>
						</c:when>
						<c:when test="${i == curPageNum }">
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="#">${i }</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="reviewList?page=${i }">
									${i }
								</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			
			<c:if test="${lastPageNumUser > lastNum }">
				<li class="page-item">
      				<a class="page-link" href="reviewList?page=${lastNum + 1 }">Next</a>
    			</li>
			</c:if>
  		</ul>
	</nav>

	<br>
	<br>
	
	<div class="container">
		<h1>미등록회원</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">이름</th>
					<th scope="col">ID</th>
					<th scope="col">또래</th>
					<th scope="col">비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${unReg }" var="UserList">
				<tr>
					<td>${UserList.u_name }</td>
					<td>${UserList.u_uid }</td>
					<td>${UserList.u_age }</td>
					<td>
						<input type="button" value="승인" onclick="userAccept('${UserList.u_uid}')">
						<input type="button" value="삭제" onclick="userRej('${UserList.u_uid}')">
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:if test="${curPageNum > 10 }">
				<li class="page-item disabled">
      				<a class="page-link" href="reviewList?page=${startNum - 1 }">Previous</a>
    			</li>
			</c:if>
			
			<c:if test="${lastPageNumUserRej < lastNum }">
				<c:forEach begin="${startNum }" end="${lastPageNumUserRej }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumUserRej }">
							<li class="page-item">${i }</li>
						</c:when>
						<c:when test="${i == curPageNum }">
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="#">${i }</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="reviewList?page=${i }">
									${i }
								</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			
			<c:if test="${lastPageNumUserRej > lastNum }">
				<c:forEach begin="${startNum }" end="${lastNum }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumUserRej }">
							<li class="page-item">${i }</li>
						</c:when>
						<c:when test="${i == curPageNum }">
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="#">${i }</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="reviewList?page=${i }">
									${i }
								</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			
			<c:if test="${lastPageNumUserRej > lastNum }">
				<li class="page-item">
      				<a class="page-link" href="reviewList?page=${lastNum + 1 }">Next</a>
    			</li>
			</c:if>
  		</ul>
	</nav>

	<br>
	<br>
	
	<div class="container">
		<h1>삭제회원</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">이름</th>
					<th scope="col">ID</th>
					<th scope="col">또래</th>
					<th scope="col">비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rejList }" var="UserList">
				<tr>
					<td>${UserList.u_name }</td>
					<td>${UserList.u_uid }</td>
					<td>${UserList.u_age }</td>
					<td><input type="button" value="복구" onclick="userRes('${UserList.u_uid}')"></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:if test="${curPageNum > 10 }">
				<li class="page-item disabled">
      				<a class="page-link" href="reviewList?page=${startNum - 1 }">Previous</a>
    			</li>
			</c:if>
			
			<c:if test="${lastPageNumUserUn < lastNum }">
				<c:forEach begin="${startNum }" end="${lastPageNumUserUn }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumUserUn }">
							<li class="page-item">${i }</li>
						</c:when>
						<c:when test="${i == curPageNum }">
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="#">${i }</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="reviewList?page=${i }">
									${i }
								</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			
			<c:if test="${lastPageNumUserUn > lastNum }">
				<c:forEach begin="${startNum }" end="${lastNum }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumUserUn }">
							<li class="page-item">${i }</li>
						</c:when>
						<c:when test="${i == curPageNum }">
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="#">${i }</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="reviewList?page=${i }">
									${i }
								</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			
			<c:if test="${lastPageNumUserUn > lastNum }">
				<li class="page-item">
      				<a class="page-link" href="reviewList?page=${lastNum + 1 }">Next</a>
    			</li>
			</c:if>
  		</ul>
	</nav>
</body>
</html>