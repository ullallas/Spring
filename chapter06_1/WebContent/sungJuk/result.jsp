<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
	*** ${sungJukDTO.name } 성적 *** <br>
	총점 : ${sungJukDTO.tot } <br>
	평균 : <fmt:formatNumber pattern="#.##">${sungJukDTO.avg }</fmt:formatNumber><br>
</h3>
</body>
</html>