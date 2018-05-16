<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--通过关键字theusername使用session对象中的
		getAttribute(String key)方法获取到用户名，
		并把用户名和第二个问题的答案显示出来。
	 -->
	<center>
		<h3>显示答案</h3>
	</center>
	<%!String food = "";%>
	<%
		food = request.getParameter("food"); //取得food参数值
		String name = (String) session.getValue("theusername"); //从session取出关键字为theusername的对象
	%>
	您的用户名：<%=name%>
	<br>您喜欢吃：<%=food%>
</body>
</html>