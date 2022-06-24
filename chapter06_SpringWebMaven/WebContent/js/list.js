//회원정보 목록
$(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		dataType: 'json',
		success: function(data){
//			alert(JSON.stringify(data));
			
			$.each(data, function(index, items){
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.name
				})).append($('<td/>', {
				    align: 'center',
				    text: items.id
			    })).append($('<td/>', {
				    align: 'center',
				    text: items.pwd
			    })).appendTo($('#userListTable'));
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});

//회원정보 수정
//$(function(){
//	$('#searchIdBtn').click(function(){
//		$('#resultDiv').empty();
//		
//		if($('#id').val() == '') 
//			$('#resultDiv').html('아이디를 입력해주세요.');
//		else
//			$.ajax({
//				type: 'post',
//				url: '/chapter06_SpringWebMaven/user/update',
//				data: 'id='+$('#id').val(),
//				success: function(data){
//					if(data == null)
//						$('#resultDiv').text('찾고자 하는 아이디가 없습니다.');
//					else {
//						$('#updateDiv').html(data);
//					}
//				},
//				error: function(err){
//					console.log(err);
//				}
//			});
//		
//	});
//});