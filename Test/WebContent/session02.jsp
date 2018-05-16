<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>回答问题页面</h3>
	</center>

	<!-- 使用request内置对象中的getParameter()方法获取到session1.jsp页面传递过来的参数值，
   			 并使用session对象中的setAttribute()方法把用户名当着对象存储在session的哈希表中，
    		这里需要指定一个关键字theusername。另外页面使用<form>向session3.jsp页面递交了另外一个参数food。
     -->
	<%
		String username = request.getParameter("username"); //获得传递参数username
		session.setAttribute("theusername", username); //把用户名保存在session中，String可以当着对象
	%>
	<p>
		您的用户名为：<%=username%>
	<p>
		<!-- 提交表单 -->
	<form action="session03.jsp">
		<table border="1" align="center">
			<tr>
				<td>您喜欢吃什么：<input type="text" name="food" size="10"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>