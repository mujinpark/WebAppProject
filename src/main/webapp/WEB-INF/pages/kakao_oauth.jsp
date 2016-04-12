<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
</head>
<body>
<script type='text/javascript'>
$(document).ready(function(){

	
});

function getUserInfo(){
	window.location.href="/user.do?accessToken=${accessToken}";
}
</script>
   <h1>KAKAO_OAUTH</h1>
   <a href = "javascript:getUserInfo();"><h2>Get User Info</h2></a>
</body>
</html>