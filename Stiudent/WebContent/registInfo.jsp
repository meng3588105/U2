<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
	<body>
	<%
		
	    request.setCharacterEncoding("UTF-8");//默认是ISO-8859-1,更改UTF-8，设置的是request内部保存数据的格式 不包括url。1.在request获取出来的数据的编码 2.改变URL编码
	    String name = request.getParameter("name");
	    String pwd = request.getParameter("pwd");
	    String[] channels = request.getParameterValues("channel");
	%>
	<div align="center">你输入的注册信息
		<table border="0" align="center">
		    <tr>
		        <td width="80" height="20">用户名:</td>
		        <td><%=name%></td>
		    </tr>
		    <tr>
		        <td height="20">密码:</td>
		        <td><%=pwd%></td>
		    </tr>
		    <tr>
		        <td height="20">信息来源:</td>
		        <td >
		        <%
		            if (channels != null) {
		                for (String channel: channels) {
		                    out.print(channel+"&nbsp;");
		                }
		            }
		        %>
		        </td>
		    </tr>
		</table>
	</div>
	</body>
</html>
