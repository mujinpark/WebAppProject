<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>Login Demo - Kakao JavaScript SDK</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

</head>
<body>
<a id="kakao-login-btn"></a>
<a href="http://alpha-developers.kakao.com/logout"></a>
<script type='text/javascript'>
$(document).ready(function(){
	// 사용할 앱의 JavaScript 키를 설정
    Kakao.init('90e7a3e34377718af878142b70036fac');
	
	function createLoginButton(){
		// 카카오 로그인 버튼을 생성
	    Kakao.Auth.createLoginButton({
	      container: '#kakao-login-btn',
	      success: function(authObj) {
	        //alert(JSON.stringify(authObj));
	   		getUserProfile();
	      },
	      fail: function(err) {
	         alert(JSON.stringify(err));
	      }
	    });
	}
	
	function getUserProfile(){
		Kakao.API.request({
			url: '/v1/api/talk/profile',
			success: function(res) {
				$("#kakao-profile").append(res.nickName);
				$("#kakao-profile").append($("<img/>",{"src":res.profileImageURL,"alt":res.nickName+"님의 프로필 사진"}));
			},
			fail: function(error) {
				console.log(error);
			}
		});
	}
	
	if(Kakao.Auth.getRefreshToken()!=undefined&&Kakao.Auth.getRefreshToken().replace(/ /gi,"")!=""){
		getUserProfile();
	}else{
		createLoginButton();
	}
});
    
    

</script>
<div id="kakao-profile"></div>
</body>
</html>
