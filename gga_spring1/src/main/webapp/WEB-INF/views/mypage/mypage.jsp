<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src ="http://localhost:9000/gga_spring1/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/gga_spring1/js/gga_jquery.js"></script>
<link rel="stylesheet" href="http://localhost:9000/gga_spring1/css/gga.css">
</head>
<body>
	<header>
		<jsp:include page="../header.jsp" />	
	</header>
	
	<!-- Content -->
	<div class= "content">
		<section class= "mypage">
			<h1 class= "title">마이페이지</h1>
			<div>
				<a href= "http://localhost:9000/gga_spring1/mypage/mypage_reservation.jsp">
				<article class= "11">내 예매 확인</article></a>
				<a href= "http://localhost:9000/gga_spring1/mypage/mypage_update.jsp">
				<article class= "22">내 정보 수정</article></a>
			</div>
		</section>
	</div>
	<!-- Footer -->
	<jsp:include page="../footer.jsp" />
	<!-- Footer -->
</body>
</html>