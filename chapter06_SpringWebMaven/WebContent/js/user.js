$(function(){
	//유효성 검사
	$('#writeBtn').click(function(){
		$('#nameDiv').empty();
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if(!$('#name').val()) {
			$('#nameDiv').html('이름을 입력해주세요.');
		} else if(!$('#id').val()) {
			$('#idDiv').html('아이디를 입력해주세요.');
		} else if(!$('#pwd').val()) {
			$('#pwdDiv').html('비밀번호를 입력해주세요.');
		} else {
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/write',
				data: $('#writeForm').serialize(),
				success: function(){
					alert('회원가입을 축하합니다.');
					location.href='/chapter06_SpringWebMaven/user/list';
				},
				error: function(err){
					console.log(err);
				}
			});
		}
	});
	
	//아이디 중복체크
	$('#id').focusout(function(){
		$('#idDiv').empty();
		
		if($('#id').val() == '')
			$('#idDiv').text('필수 정보입니다.');
		else
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/checkId',
				data: 'id='+$('#id').val(),
				dataType: 'text',
				success: function(data){
					if(data == 'exist')
						$('#idDiv').text('사용 불가능');
					else {
						$('#idDiv').text('사용 가능');
						$('#idDiv').css('color', 'blue');
					}
				},
				error: function(err){
					console.log(err);
				}
			});
		
	});
});