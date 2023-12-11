<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="header.jsp"%>
<title>상품페이지</title>
</head>
<body>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta name="description" content="multikart">
<meta name="keywords" content="multikart">
<meta name="author" content="multikart">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/productDetail.css">
<title>PGC Board</title>
<script>
	function rental(g_id, g_name) {
		var width = 400;
		var height = 300;
		var positionX = (window.screen.width / 2) - (width / 2);
        var positionY = (window.screen.height / 2) - (height / 2);
        console.log(g_name);
        console.log(typeof(g_name));
        
		window.open(
				"rental?g_id=" + g_id + "&g_name=" + g_name, 	// 링크
				"rental",	// 새 창 아이디
				"width=" + width +
				", height=" + height +
				", top=" + positionY +
				", left=" + positionX);
		
		return false;
	};
</script>
</head>

<body>
<c:forEach items="${game }" var="GameDTO">

	<!-- section start -->
		<section>
			<div class="collection-wrapper">
				<div class="container">
					<div class="row">
						<div class="col-lg-5 col-sm-10 col-xs-12">
							<div class="product-right-slick">
								<div>
									<img src="${pageContext.request.contextPath }/resources/assets/img/defaultImage.jpg">
								</div>
							</div>
						</div>
						<div class="col-lg-6 rtl-text">
							<div class="product-right">
								<h2>${GameDTO.g_name }</h2>
								<div class="border-product">
									<h6 class="product-title">게임 설명</h6>
									<p>${GameDTO.g_content }</p>
								</div>
								<div class="product-buttons">
									
										<c:set var="g_rent" value="${GameDTO.g_rent }" />
										<c:choose>
											<c:when test="${g_rent == 1 }">
												<a href="#" data-toggle="modal"
													class="btn btn-solid" onclick="rental(${GameDTO.g_id }, '${GameDTO.g_name }')">대여하기</a>
											</c:when>
											<c:when test="${g_rent == 0 }">
												<a href="#" data-toggle="modal" data-target="#addtocart" 
													class="btn btn-solid">대여중</a>
											</c:when>
											<c:otherwise>대여불가</c:otherwise>
										</c:choose>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	<!-- Section ends -->
	<hr style="border=0; height=3px; color=#CCC">
		<div class="card-body p-4">
			<div class="d-flex flex-start">
				<div>
					<form action=insertReview method="post">
						<h6 class="fw-bold mb-1">작성자 : <input type="text" size=10 value=<%=session.getAttribute("u_uid") %> readonly></h6>
						<p class="mb-0">
						<textarea rows="5" cols="30" id="r_content" name="r_content" placeholder="내용을 작성해주세요."></textarea>
						<input type="hidden" id="r_uid" name="r_uid" value="<%=session.getAttribute("u_id") %>">
						<input type="hidden" id="r_gid" name="r_gid" value="${GameDTO.g_id }">
						<input type="submit" value="작성하기">
                		</p>
					</form>
				</div>
			</div>
		</div>
</c:forEach>
        
        <hr>
        
<section>
	<div class="container my-5 py-5">
		<div class="row d-flex justify-content-center">
			<div class="col-md-12 col-lg-10">
				<c:forEach items="${reviewList }" var="Review">
				<div class="card text-dark">
					<div class="card-body p-4">

						<div class="d-flex flex-start">
							<div>
								<h6 class="fw-bold mb-1">${Review.u_name }</h6>
									<div class="d-flex align-items-center mb-3">
										<p class="mb-0">
										${Review.r_date }
                  						</p>
                					</div>
                					<p class="mb-0">
                  					${Review.r_content }
                					</p>
              				</div>
            			</div>
          			</div>

          			<hr class="my-0" />
        
        		</div>
				</c:forEach>
      		</div>
    	</div>
	</div>
</section>
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