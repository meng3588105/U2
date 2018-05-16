<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="doLogin.jsp" method="get">
		<input type="text" name="userName" placeholder="请输入用户名">
		<input type="password" name="pwd" placeholder="请输入密码">
	

	个人爱好：<br/>
	<input type="checkbox" name="lon" value="java">java<br/>
	<input type="checkbox" name="lon" value="sql">"sql"<br/>
	<input type="checkbox" name="lon" value="js">js<br/>
	
	<input type="submit" value="提交">
	
	
	
	
	</form>
	
</body>
</html>