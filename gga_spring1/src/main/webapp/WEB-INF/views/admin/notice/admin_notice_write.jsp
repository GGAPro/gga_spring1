<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GGA_Test1</title>
<link rel="stylesheet" href="http://localhost:9000/gga_spring1/css/gga.css"> <!-- gga.css -->
<script src="http://localhost:9000/gga_spring1/js/jquery-3.6.4.min.js"></script> <!-- gga_javascript.js -->
<script src="http://localhost:9000/gga_spring1/js/gga_javascript.js"></script> <!-- gga_javascript.js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
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
.ninput{
	width:95%;
	border-color:#ddd;
}
.ntextarea{
	width:95%;
	border-color:#ddd;
}
</style>
<script>
/* function writeCheck(){
	let ntitle = document.getElementById("ntitle");
	let ntextarea = document.getElementById("ntextarea");
	if(ntitle.value == ""){
		alert("제목를 작성해주세요");
		ntitle.focus();
		return false;
	} else if(ntextarea.value == 0) {
		alert("내용를 작성해주세요");
		ntextarea.focus();
		return false;
	} else {
		writeForm.submit();
	}
}


function writeReset(){
	document.getElementById("ntitle").value = "";
	document.getElementById("ntextarea").value = "";
	document.getElementById("id").focus;
} */
</script>
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
			<form name="writeForm" action="admin_notice_write_proc.do"  method="post">
				<table class="table table-bordered" style="width: 90%;">
					<tr>
						<th>제목</th>
						<td colspan="3">
							<input type="text" name="ntitle" class="ninput" id="ntitle" value="${noticevo.ntitle}">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="20" cols="80%" name="ncontent" class="ntextarea" id="ntextarea">${noticevo.ncontent }</textarea>
						</td>
					</tr>					
					<tr>
						<td colspan="4">
							<button class="btn btn-outline-secondary" type="button" id="btnNoticeWrite">등록완료</button>
							<button class="btn btn-outline-secondary" type="reset" >다시쓰기</button>
							<a href="admin_notice_list.do">
								<button class="btn btn-outline-secondary" type="button">이전으로</button></a>
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
	<!-- content -->


	
	<!-- footer -->
	<footer>
		<jsp:include page="../../footer.jsp" />
	</footer>
	<!-- footer -->
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script> <!-- 부트스트랩 -->
</body>
</html>