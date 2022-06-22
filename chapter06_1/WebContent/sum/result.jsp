<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h3>${param.x } + ${param.y } = ${param.x + param.y}</h3> 컨트롤러 2번째까지 사용--%>
<%-- <h3>${x } + ${y } = ${x + y}</h3> 컨트롤러 5번째까지 사용 --%>
<h3>${sumDTO.x } + ${sumDTO.y } = ${sumDTO.x + sumDTO.y}</h3>
</body>
</html>