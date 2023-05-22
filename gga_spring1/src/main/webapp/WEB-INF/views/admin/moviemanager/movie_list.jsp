<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gga_spring1</title>
<link rel="stylesheet" href="http://localhost:9000/gga_spring1/css/gga.css"> <!-- gga.css -->
<script src="http://localhost:9000/gga_spring1/js/gga_javascript.js"></script> <!-- gga_javascript.js -->
<script src="http://localhost:9000/gga_spring1/js/gga_jquery.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
	<!-- 부트스트랩 -->
</head>
<style>
@media (min-width: 768px) {
  .container {
    width: 750px;
  }
}

@media (min-width: 992px) {
  .container {
    width: 1000px;
  }
}
section.moviemanager table {
		margin:auto;
} 


</style>

<body>
	<!-- header -->
	<header>
		<jsp:include page="../../header.jsp" />
	</header>
	<!-- header -->
	
	<!-- content -->
	<div class="container text-center">
	<div class="board_title">
		<h1>영화 리스트</h1>
		</div>
		<section class="moviemanager">
			<table class="table table-bordered" style="width: 90%;">
				<tr>
					<td colspan="7">
						<a href="http://localhost:9000/gga_spring1/movie_register.do">
						<button type="button">영화 추가</button></a>
						<br><br>
					</td>
				</tr>
				<tr>
					<th>번호</th>
					<th>영화ID</th>
					<th>영화 제목</th>
					<th>장르</th>
					<th>개봉일</th>
					<th>상영 시간</th>
					<th>관객수</th>
				</tr>
				<c:forEach var="movieVo" items="${movieList}">
				<tr>
					<td>${movieVo.rno}</td>
					<td>${movieVo.movieid}</td>
					<td><a href="movie_content.do?movieid=${movieVo.movieid}">${movieVo.mtitle}</a></td>
					<td>${movieVo.genre}</td>
					<td>${movieVo.moviedday}</td>
					<td>${movieVo.runtime}</td>
					<td>${movieVo.audience}</td>
				</tr>
				</c:forEach>
			</table>
		</section>
	</div>
	<!-- content -->


	<!-- footer -->
	<footer>
		<jsp:include page="../../footer.jsp" />
	</footer>
	<!-- footer -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK
	/7HAuoJl+0I4" crossorigin="anonymous"></script> <!-- 부트스트랩 -->
</body>
</html>