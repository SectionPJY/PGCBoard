<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/userList.css">
<script
	src="${pageContext.request.contextPath }/resources/js/gameList.js"></script>
<title>게임목록</title>
</head>
<body>
	<br>
	<h4>등록게임</h4>
	<!-- paging -->
	<nav aria-label="Page navigation example">
		<ul class="pagination pagination-seperated ">
			<table id="dtBasicExample"
				class="table table-striped table-bordered table-sm" cellspacing="0">
				<thead>
					<tr>
						<th class="th-sm">ID</th>
						<th class="th-sm">이름</th>
						<th class="th-sm">대여여부</th>
						<th class="th-sm">비고</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${gameList }" var="GameList">
						<tr>
							<td>${GameList.g_id }</td>
							<td>${GameList.g_name }</td>
							<td><c:set var="g_rent" value="${GameList.g_rent }" /> <c:choose>
									<c:when test="${g_rent == 1 }">대여가능</c:when>
									<c:when test="${g_rent == 0 }">대여중</c:when>
									<c:otherwise>대여불가</c:otherwise>
								</c:choose></td>
							<td><input type="button" value="조회"
								onclick="gameInfo('${GameList.g_id}')"> <input
								type="button" value="삭제" onclick="gameRej('${GameList.g_id}')">
								<c:set var="g_rent" value="${GameList.g_rent }" />
								<c:choose>
									<c:when test="${g_rent == 0 }">
										<input type="button" value="반납" onclick="returnGame('${GameList.g_id}')">
									</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</ul>
	</nav>
</body>
</html>