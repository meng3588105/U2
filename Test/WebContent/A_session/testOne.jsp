<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 使用response对象将页面重定向至testTwo.jsp，在testTwo.jsp中能够读取到sessionName变量
		，由此可见session作用域内的数据在会话有效期内都可以访问。使用response.sendRedirect()
		重定向到另外一个页面时，相当于重新发起了一次请求，所以上一次请求中的reqName变量则随之失效
	 -->
	<%
		String req = "request";
		String ses = "session";
		request.setAttribute("reqName", req);
		session.setAttribute("sessionName", ses);
		response.sendRedirect("testTwo.jsp");
		
	%>


</body>
</html>