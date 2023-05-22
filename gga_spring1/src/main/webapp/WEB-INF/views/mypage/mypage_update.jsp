<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 - 내 정보 수정</title>
<script src ="http://localhost:9000/gga_spring1/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="http://localhost:9000/gga_spring1/css/gga.css">
<script src="http://localhost:9000/gga_spring1/js/gga_jquery.js"></script>
</head>
<body>
	<header>
		<jsp:include page="../header.jsp" />	
	</header>
	
	<!-- Content -->
	<div class= "content">
		<section class= "mp_update">
			<h1 class= "title">내 정보 수정</h1>
			<form name= "mp_updateForm" action="#" method= "get">
				<ul>
					<li>
						<label>이름</label>
						<input type="text" id="name" name="name" class= "input1" value="홍길동" readonly>
					</li>
					<li>
						<label>아이디</label>
						<input type="text" id="id" name="id" class= "input1" value="hong123" readonly>
					</li>
					<li>
						<label>비밀번호</label>
						<input type="password" id="pass" name="pass" class= "input1">
					</li>
					<li>
						<label>비밀번호 확인</label>
						<input type="password" id="cpass" name="cpass" class= "input1">
						<button type="button" id="btn_passUpdate" class= "btn_style2">변경</button>
					</li>
					<li>
						<label>성별</label>
						<input type="radio" name="gender"><span>남자</span> 
						<input type="radio" name="gender"><span>여자</span>
					</li>
					<li>
						<label>이메일</label>
						<input type="text" name="email1" > @
						<input type="text" name="email2" >
						<select>
							<option value="default">선택</option>
							<option value="naver.com">naver.com</option>
							<option value="nate.com">nate.com</option>
							<option value="google.com">google.com</option>
							<option value="daum.net">daum.net</option>
						</select>
					</li>
					<li>
						<label>차량번호</label>
						<input type="text" name="carnum" class="input1" placeholder= "본인 차량번호 정확하게 기입">
					</li>
					<li>
						<label>휴대폰</label>
						<input type="radio" name="tel" value="skt"><span>SKT</span>
						<input type="radio" name="tel" value="kt"><span>KT</span>
						<input type="radio" name="tel" value="lgu+"><span>LG U+</span>
						<select name="phone1">
							<option value="default">선택</option>
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
						</select>
						- <input type="text" name="phone2">
						- <input type="text" name="phone3">
					</li>
					<li>
						<label>영화 장르</label>
						<input type="checkbox" name="genre" value="범죄/스릴러"><span>범죄/스릴러</span>
						<input type="checkbox" name="genre" value="멜로/로맨스"><span>멜로/로맨스</span>
						<input type="checkbox" name="genre" value="판타지/코미디"><span>판타지/코미디</span>
						<input type="checkbox" name="genre" value="액션/SF"><span>액션/SF</span><br>
						<input type="checkbox" name="genre" value="전쟁/재난"><span>전쟁/재난</span>
						<input type="checkbox" name="genre" value="느와르/첩보"><span>느와르/첩보</span>
						<input type="checkbox" name="genre" value="애니메이션"><span>애니메이션</span>
						<input type="checkbox" name="genre" value="가족/음악"><span>가족/음악</span>
					</li>
					<button type="submit" class= "btn_style">저장</button>
				</ul>
			</form>
		</section>
	</div>
	
	<!-- Footer -->
	<jsp:include page="../footer.jsp" />
	<!-- Footer -->
</body>
</html>