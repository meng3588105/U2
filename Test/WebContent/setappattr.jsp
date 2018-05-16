<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 此处调用了application内置对象中的setAttribute()方法来存储用户名信息以及计数初始值。

			另外在相同目录下创建另外一个getappattr.jsp文件，用于获取计数值。 
	-->
	<h4>获得application信息</h4>
	<br>ServletInfo:<%=application.getServerInfo()%>
	<br>application.jsp real path:
	<%=application.getRealPath("/application.jsp")%>
	<br>HelloServlet Real Path:
	<%=application.getRealPath("/servletsample/HelloServlet")%>
	<br>Major Version:
	<%=application.getMajorVersion()%>
	<br>get MIME:
	<%=application.getMimeType("/servletsample/demo.htm")%>
	<br>getResource:
	<%=application.getResource("/HelloJSP.jsp")%>
	<%
		out.println("<br><h4>设置数值</h4>");
		application.setAttribute("name", "zzb"); //把字符串“zzb”对象保存在application中  
		application.setAttribute("counter", "1"); //把字符串值“1”保存在application中  
		out.println("set name=zzb");
		out.println("<br>set counter=1");
	%>
</body>
</html>