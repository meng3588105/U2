<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLConnection"%>
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
		//获取响应所有Cookie
		Cookie[] cookie = request.getCookies();
		//非空判断
		if (cookie != null) {
			for (int i = 0; i < cookie.length; i++) {
				if (cookie[i].getName().equals("userName")) {
					out.println(URLDecoder.decode(cookie[i].getValue(), "UTF-8"));//需要解码操作

				}
				if (cookie[i].getName().equals("password")) {
					out.println(cookie[i].getValue());

				}
			}
		}
	%>


</body>
</html>