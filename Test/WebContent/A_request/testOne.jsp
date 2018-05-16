<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 
		在testOne.jsp页面中，通过RequestDispatcher对象的forward()方法转发至testTow.jsp,
		属于一次请求，在同一个request作用域内，所有在testTwo.jsp 页面中可以访问到这个String对象
	 -->
	
	<%
		String name ="requset";
		request.setAttribute("name", name);
		request.getRequestDispatcher("testTwo.jsp").forward(request, response);
	
	%>
	
</body>
</html>