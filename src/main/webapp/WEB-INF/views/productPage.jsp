<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/productPage.css">
<meta charset="UTF-8">
<script type="text/javascript">
	function productDetail(g_id) {
		const url = "http://localhost:8080/ex/productDetail?g_id=" + g_id;

		window.location.href = url;
	};
</script>
<title>보드게임</title>
</head>
<body>
	<!-- Document Wrapper=============================== -->
	<div id="pageWrapper">

		<!-- Content
========================================= -->
		<div id="content">
			<div class="contentWrapper">
				<div class="container">

					<!-- Product List
					============================================= -->
					<div id="productListWrapper">

						<!-- Product List
						============================================= -->
						<c:forEach items="${gameList }" var="games">
							<a href="#" onclick="productDetail('${games.g_id }')">
								<div class="products">

									<div class="productCard card blue">
										<div class="productImage">
											<img
												src="${pageContext.request.contextPath }/resources/assets/img/defaultImage.jpg">
										</div>
										<div class="productInfo">
											<h5>${games.g_name }</h5>
										</div>
									</div>
								</div>
							</a>
						</c:forEach>
					</div>
					<!-- #productListWrapper end -->

				</div>
				<!-- ".container" end -->

			</div>
			<!-- .contentWrapper end -->

		</div>
		<!-- #content end -->

	</div>
	<!-- #pageWrapper end -->
</body>
</html>