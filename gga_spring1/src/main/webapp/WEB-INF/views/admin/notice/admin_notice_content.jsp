<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GGA_Test1</title>
<link rel="stylesheet" href="http://localhost:9000/gga_spring1/css/gga.css"> <!-- gga.css -->
<script src="http://localhost:9000/gga_spring1/js/jquery-3.6.4.min.js"></script> <!-- gga_javascript.js -->
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
section.admin_notice table {
	text-align:center;
	margin:auto;
}
.binput{
	width:95%;
	border-color:#ddd;
}
.btextarea{
	width:95%;
	border-color:#ddd;
}
.table td {
text-align:left;
}
.table tr:last-child td {
text-align:center;
}
</style>
<!-- <script>
function cdelete(){
	if(window.confirm("정말로 삭제하시겠습니까?")){
		
	}
}

function cupdate(){
	if(window.confirm("정말로 수정하시겠습니까?")){
		window.location.href="admin_notice_update.do";
	}
}
</script> -->
<body>
	<!-- header -->
	<header>
		<jsp:include page="../../header.jsp" />
	</header>
	<!-- header -->
	
	
	<!-- content -->
	<div class="container text-center">
		<section class="admin_notice">
			<h1>관리자 - 공지사항</h1>
				<table class="table table-bordered" style="width: 90%;">
					<tr>
						<th>제목</th>
						<td>${noticeVo.ntitle}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							${noticeVo.ncontent }<br><br><br>
						</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${noticeVo.nhits }</td>
					</tr>
					<tr>
						<th>작성일자</th>
						<td>${noticeVo.ndate }</td>
					</tr>					
					<tr>
						<td colspan="4">
							<a href="admin_notice_update.do?nid=${noticeVo.nid }">
							<button class="btn btn-outline-secondary" type="button" id="btnNoticeUpdate" >수정하기</button></a>
							
							<a href="admin_notice_delete.do?nid=${noticeVo.nid}">
							<button class="btn btn-outline-secondary" type="button">삭제하기</button></a>
							<a href="admin_notice_list.do">
								<button class="btn btn-outline-secondary" type="button">이전으로</button></a>

						</td>				
					</tr>
				</table>
		</section>
	</div>
	<!-- content -->



	<!-- footer -->
	<footer>
		<jsp:include page="../../footer.jsp" />
	</footer>
	<!-- footer -->
	
	
	<!-- footer -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK
	/7HAuoJl+0I4" crossorigin="anonymous"></script> <!-- 부트스트랩 -->
</body>
</html>