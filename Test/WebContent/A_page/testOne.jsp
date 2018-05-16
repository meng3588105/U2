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
	在testOne.jsp页面中，调用pageContext对象的setAttribute()方法、
	将一个String对象保存到page作用域，然后在本页面中调用pageContext对象的
	getAttribute()方法可以访问到这个String对象，而在testTwo.jsp
	页面中，也就是另一个page作用域中，则无法访问到该String对象，
	显示是：testTwo:null,当然，这个结果是通过pageContext对象的include()
	方法将testTwo.jsp的响应结果包含到testOne.jsp页面中的。

 -->
	<%
	String name="page";
	pageContext.setAttribute("name", name);
	%>
	<strong>
		testOne:<%=pageContext.getAttribute("name")%>
	</strong>
	<%@ include file="testTwo.jsp" %>
	<%
	 	pageContext.include("testTwo.jsp");
	%>
</body>
</html>