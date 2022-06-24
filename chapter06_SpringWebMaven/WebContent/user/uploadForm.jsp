<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#img {
	visibility: hidden;
}
</style>
</head>
<body>
<!-- 1번. 단순 submit, method="post" enctype="multipart/form-data" 필수 -->
<%-- <form id="uploadForm" method="post" enctype="multipart/form-data" 
action="/chapter06_SpringWebMaven/user/upload"> <!-- 반드시 post. get은 안됨 --> --%>

<!-- 2번. Ajax 통신 -->
<form id="uploadForm">

<h3>파일을 1개씩 선택하여 업로드</h3>
<input type="file" name="img">
<input type="file" name="img">
<br>

<h3>파일을 여러개 선택하여 업로드</h3>
<img src="../img/camera.png" width="70" height="70" id="camera" style="cursor: pointer;">
<input type="file" name="img[]" id="img" multiple>

<br><br>
<input type="button" id="uploadBtn" value="이미지 등록">

</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#camera').click(function(){
		$('#img').trigger('click');
	});
	
	
	$('#uploadBtn').click(function(){
		//1번. 단순 submit
		//$('#uploadForm').submit();
		
		//2번. Ajax 통신
		var formData = new FormData($('#uploadForm')[0]); //<form /> 안의 모든 것
		
		$.ajax({
			type: 'post', //반드시 post
			url: '/chapter06_SpringWebMaven/user/upload',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(){
				alert('업로드 완료')
			},
			error: function(err){
				console.log(err);
			}
		});
	});
});
</script>
</body>
</html>

<!-- 
processData
 - 기본값은 true
 - 기본적으로 Query String으로 변환해서 보내진다('변수=값&변수=값')
 - 파일 전송시에는 반드시 false로 해야 한다.(formData를 문자열로 변환하지 않는다)
 
contentType
  - 기본적으로 "application/x-www-form-urlencoded; charset=UTF-8"
  - 파일 전송시에는 'multipart/form-data'로 전송이 될 수 있도록 false로 설정한다
 -->



