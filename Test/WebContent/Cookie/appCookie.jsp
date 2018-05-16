<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//创建用户名和密码两个cookie  如果有中文  务必设置编码格式
		Cookie c1=new Cookie("userNmae",URLEncoder.encode("大龙","UTF-8"));
		Cookie c2=new Cookie("password","9999");
		c1.setMaxAge(10);//设置userName这个cookie的有效期   默认保存在本地
		//通过response对象新增cookie
		response.addCookie(c1);
		response.addCookie(c2);
		//重定向
		response.sendRedirect("getCookie.jsp");
	
	%>
</body>
</html>