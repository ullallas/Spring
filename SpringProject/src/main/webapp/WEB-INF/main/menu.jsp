<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
.mainnav {
	background-color: #FFEAEC;
	list-style: none;
	color: #FFFFFF;
}
.mainnav li {
	display: inline-block;
	justify-content: space-between;
}
.mainnav li a {
	display: block;
	color: #FFFFFF;
	padding: 0 13px; /* 위/아래, 좌우 */
	background-color: black;
	font: bold 16px/40px 'Nanum Gothic', sans-serif; /* 'Nanum Gothic', --> 중간에 공간이 있어서 쉼표 찍음 */
	/* 폰트의 굵기 | 글자의 크기/line-height 줄간격 | 글꼴 - 앞의 글꼴이 없으면 다음 글꼴 */
	text-transform: uppercase;
	text-decoration: none;
}
.mainnav li a:hover {
	color: white;
	background-color: purple;
}
/* #write:hover, #list:hover {
	color: white;
	background-color: purple;
} */

</style>

<ul class="mainnav">
	<c:if test="${memId != null }">
		<li><a href="/SpringProject/board/boardWriteForm">글쓰기</a></li>
		<li><a href="/SpringProject/imageboard/imageboardWriteForm">상품등록</a></li>
	</c:if>
		<li><a href="/SpringProject/board/boardList">목록</a></li>
		<li><a href="/SpringProject/imageboard/imageboardList">상품목록</a></li>
</ul>

