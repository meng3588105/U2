<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--	运行testOne.jsp 
	结果显示:
			session:session
			application:application
		这时以一个新的会话开启另一个浏览器窗口，直接访问testTwo.jsp页面
	结果显示：
		session:null
		application:application
		
	session作用域针对当前会话，多个会话之间不能共享，所以无法读取sesName变量
	。而application作用域针对整个应用，因而appName变量可以被再次读取到
	（注：若重启Web应用，现有的application作用域失效）
	
	 -->
	
	<%
		String app="application";
		String ses="session";
		session.setAttribute("sesName", ses);
		application.setAttribute("appName", app);
		response.sendRedirect("testTwo.jsp");
	
	%>

</body>
</html>