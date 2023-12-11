<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="com.spring.ex.dao.ReviewDAO"%>
<%@ page import="java.util.List"%>
<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/reviewList.js"></script>
<title>리뷰관리</title>
</head>
<body>
	<div class="container">
		<h1>리뷰목록</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">작성내용</th>
					<th scope="col">비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reviewList }" var="Review">
				<tr>
					<td>${Review.u_name }</td>
					<td>${Review.r_date }</td>
					<td>${Review.r_content }</td>
					<td>
						<input type="button" onclick="reviewDelete('${Review.r_id}')" value="삭제">
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
			
			<c:if test="${lastPageNum < lastNum }">
				<c:forEach begin="${startNum }" end="${lastPageNum }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNum }">
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
			
			<c:if test="${lastPageNum > lastNum }">
				<c:forEach begin="${startNum }" end="${lastNum }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNum }">
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
			
			<c:if test="${lastPageNum > lastNum }">
				<li class="page-item">
      				<a class="page-link" href="reviewList?page=${lastNum + 1 }">Next</a>
    			</li>
			</c:if>
  		</ul>
	</nav>
</body>
</html>