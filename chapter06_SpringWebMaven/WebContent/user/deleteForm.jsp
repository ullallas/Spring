<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#resultDiv {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<img src="../img/kyun's rose.jpg" alt="균의 장미" width="100" height="100" 
	onclick="location.href='../index.jsp'" style="cursor: pointer;">
<p>
	삭제 할 아이디 입력 <input type="text" name="searchId" id="searchId">
	<input type="button" value="검색" id="searchIdBtn">
</p>

<div id="resultDiv">
	<!-- 동적 처리 -->
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$('#searchIdBtn').click(function(){
	$('#resultDiv').empty();
	
	if($('#searchId').val() == '')
		$('#resultDiv').text('아이디를 입력하세요')
	else
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/getUser',
			data: 'id='+$('#searchId').val(),
			success: function(data){
				if(data == ''){
					$('#resultDiv').text('찾고자 하는 아이디가 없습니다.');
				} else {
					if(confirm('정말로 삭제하시겠습니까?')){
						$.ajax({
							type: 'post',
							url: '/chapter06_SpringWebMaven/user/delete',
							data: 'id='+$('#searchId').val(),
							success: function(){
								alert('회원님의 정보를 삭제하였습니다.');
								location.href='/chapter06_SpringWebMaven/user/list';
							},
							error: function(err){
								console.log(err);
							}
						});
					}
				}
			},
			error: function(err){
				console.log(err);
			}
		});
});
</script>
</body>
</html>