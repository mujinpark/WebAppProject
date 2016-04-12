<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>User Info</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type='text/javascript'>
$(document).ready(function(){
	//JSON.stringify(${responseBody});
	var obj = jQuery.parseJSON( '${responseBody}' );
	$("#kakao-profile-nickname").append(obj.properties.nickname);
	$("#kakao-profile-image").append($("<img/>",{"src":obj.properties.profile_image,"alt":obj.properties.nickname+"님의 프로필 사진"}));
});

</script>
</head>
<body>
<div id="kakao-profile-nickname"></div>
<div id="kakao-profile-image"></div>
</body>
</html>