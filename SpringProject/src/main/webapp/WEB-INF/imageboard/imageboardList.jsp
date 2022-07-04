<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#currentPaging {
	color: red;
	text-decoration: underline;
	cursor: pointer;
}
#paging {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>
<input type="text" id="pg" value="${pg }"> <!-- 컨트롤러에서 받아옴 -->

<form id="imageboardListForm" method="get" action="/SpringProject/imageboard/imageboardDelete">
<table id="imageboardListTable" border="1" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<th width="100"><input type="checkbox" id="all">번호</th>
		<th width="150">이미지</th>
		<th width="150">상품명</th>
		<th width="150">단가</th>
		<th width="100">개수</th>
		<th width="150">합계</th>
	</tr>
	
	<!-- 동적처리 -->
</table>

<input type="button" id="imageboardDeleteBtn" value="선택삭제" style="margin: 5px 10px; float: left;">

<div id="imageboardPagingDiv" style="border: 1px solid red; width: 600px; float: left; text-align: center;">
	<!-- 동적처리 -->
</div>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function imageboardPaging(pg2){
	location.href = "/SpringProject/imageboard/imageboardList?pg="+pg2;
}
</script>
<script type="text/javascript">
$(function(){
	
	$.ajax({
		type: 'post',
		url: '/SpringProject/imageboard/getImageboardList',
		data: {'pg': $('#pg').val()},
		dataType: 'json',
		success: function(data){
			//console.log(JSON.stringify(data));
			
			$.each(data.list, function(index, items){ //console.log로 찍어보면 값을 list로 받아옴
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
					}).prepend($('<input/>', {
						type: 'checkbox',
						name: 'check',
						value: items.seq
					}))
				).append($('<td/>',{
					align: 'center',
				
					}).append($('<img/>',{
						src: '/SpringProject/storage/'+items.image1,
						style: 'width: 70px; height: 70px'
					}))
				
				).append($('<td/>',{
					align: 'center',
					text: items.imageName
				})).append($('<td/>',{
					align: 'center',
					text: items.imagePrice.toLocaleString()
				})).append($('<td/>',{
					align: 'center',
					text: items.imageQty.toLocaleString()
				})).append($('<td/>',{
					align: 'center',
					text: (items.imagePrice * items.imageQty).toLocaleString()
				})).appendTo($('#imageboardListTable'));
			}); //each
			
			//페이징처리
			$('#imageboardPagingDiv').html(data.imageboardPaging.pagingHTML);
		},
		
		error: function(err){
			console.log(err);
		} 
	});//$.ajax
	
	//전체 선택 또는 전체 선택 해제
	$('#all').click(function(){
		//alert($('#all').attr('checked')) //checked라는 속성이 없어서 undefined라고 나온다
		//alert($('#all').prop('checked')) //true 또는 false
		
		if($('#all').prop('checked'))
			$('input[name="check"]').prop('checked', true);
		else
			$('input[name="check"]').prop('checked', false);
	});
	
	//선택삭제
	$('#imageboardDeleteBtn').click(function(){
		var count = $('input[name="check"]:checked').length;
		
		if(count == 0)
			alert('삭제할 항목을 선택하세요');
		else
			if(confirm('정말로 삭제하시겠습니까?')) $('#imageboardListForm').submit();
	});
	
});
</script>
</body>
</html>