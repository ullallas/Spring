<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#writeForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<img src="../img/kyun's rose.jpg" alt="균의 장미" width="100" height="100" 
	onclick="location.href='../index.jsp'" style="cursor: pointer;">

<form id="writeForm" method="post" >
  <table border="1" >
     <tr>
	     <td>이름</td>
	     <td>
	        <input type="text" name="name" id="name">
	        <div id="nameDiv"></div>
	     </td>
     </tr>
     <tr>
    	 <td>아이디</td>
	     <td>
	         <input type="text" name="id" id="id">
	         <div id="idDiv"></div>
	     </td>
  	 </tr>
     <tr>
     	 <td>비밀번호</td>
	     <td>
	         <input type="password" name="pwd" id="pwd">
	         <div id="pwdDiv"></div>
	     </td>
  	 </tr>
     <tr>
	     <td colspan="2" align="center">
	        <input type="button" value="회원가입" id="writeBtn">
	        <input type="reset" value="다시작성">
	     </td>
  	 </tr>
  </table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/user.js"></script>
</body>
</html>