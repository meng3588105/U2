<%@page import="com.mxl.User"%>
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
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		session.setAttribute("user",new User(userName,password) );
	
		response.sendRedirect("");
	
	%>
	<h1>33</h1>
</body>
</html>