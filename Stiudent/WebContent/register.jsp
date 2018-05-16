<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学员注册</title>
    
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
	<div align="center">请输入注册信息
		<form name="form1" method="post" action="registInfo.jsp">
    		<table  border="0" align="center">
     			 <tr> 
        			<td>用户名：</td>
        			<td><input type="text" name="name"></td>
      			</tr>
				<tr> 
			        <td height="19">密码：</td>
			        <td height="19"><input type="password" name="pwd"></td>
				</tr>
				<tr> 
        			<td>信息来源：</td>
        			<td> 
						<input type="checkbox" name="channel" value="报刊">报刊 
				        <input type="checkbox" name="channel" value="网络">网络<br/> 
				        <input type="checkbox" name="channel" value="朋友推荐">朋友推荐 
				        <input type="checkbox" name="channel" value="电视">电视
       				</td>
      			</tr>
      			<!-- 以下是提交、取消按钮 -->
      			<tr > 
        			<td colspan="2" align="center" > 
          				<input type="submit" name="Submit" value="提交">
          				<input type="reset" name="Reset" value="取消">
        			</td>
      			</tr>
    		</table>
  		</form>
	</div>
	</body>
</html>

