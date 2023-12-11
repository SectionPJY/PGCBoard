<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여정보</title>
</head>
<body>	
	<div class="container">
		<h1>대여목록</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">대여번호</th>
					<th scope="col">대여자</th>
					<th scope="col">대여게임</th>
					<th scope="col">대여날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${renList }" var="RentalList">
				<tr>
					<td>${RentalList.r_id }</td>
					<td>${RentalList.u_name }</td>
					<td>${RentalList.g_name }</td>
					<td>${RentalList.r_date }</td>
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
			
			<c:if test="${lastPageNumRental < lastNum }">
				<c:forEach begin="${startNum }" end="${lastPageNumRental }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumRental }">
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
			
			<c:if test="${lastPageNumRental > lastNum }">
				<c:forEach begin="${startNum }" end="${lastNum }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumRental }">
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
			
			<c:if test="${lastPageNumRental > lastNum }">
				<li class="page-item">
      				<a class="page-link" href="reviewList?page=${lastNum + 1 }">Next</a>
    			</li>
			</c:if>
  		</ul>
	</nav>
	
	<br><br>
	
	<div class="container">
		<h1>반납목록</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">대여번호</th>
					<th scope="col">대여자</th>
					<th scope="col">대여게임</th>
					<th scope="col">반납날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${returnList }" var="RentalList">
				<tr>
					<td>${RentalList.r_id }</td>
					<td>${RentalList.u_name }</td>
					<td>${RentalList.g_name }</td>
					<td>${RentalList.r_rdate }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- Paging -->
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:if test="${curPageNum > 10 }">
				<li class="page-item disabled">
      				<a class="page-link" href="rentalList?page=${startNum - 1 }">Previous</a>
    			</li>
			</c:if>
			
			<c:if test="${lastPageNumReturn < lastNum }">
				<c:forEach begin="${startNum }" end="${lastPageNumReturn }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumReturn }">
							<li class="page-item">${i }</li>
						</c:when>
						<c:when test="${i == curPageNum }">
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="#">${i }</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="rentalList?page=${i }">
									${i }
								</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			
			<c:if test="${lastPageNumReturn > lastNum }">
				<c:forEach begin="${startNum }" end="${lastNum }" var="i">
					<c:choose>
						<c:when test="${i > lastPageNumReturn }">
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
			
			<c:if test="${lastPageNumReturn > lastNum }">
				<li class="page-item">
      				<a class="page-link" href="reviewList?page=${lastNum + 1 }">Next</a>
    			</li>
			</c:if>
  		</ul>
	</nav>
</body>
</html>