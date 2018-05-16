<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  
  昵称：<input type="text" name="userName" required />
     <div id="result"></div>
   
   
   
   	<!-- 导入jQ包 -->
   <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
   <script type="text/javascript">
    
/**
 * 昵称失去焦点时的事件
 jQuery来实现我们的ajax
 
 	$.ajax({
 		url:服务器的地址,
 		type：请求方式,
 		data:需要传递给后台的数据,
 		dataType:希望服务器返回的数据类型 xml html js text
 		beforeSend:发送请求之前执行的函数,
 		success:响应成功之后执行的函数,
 		error：响应失败执行的函数
	
 	});
 
 
 */
	$("[name='userName']").blur(function() {
		var userName=$("[name='userName']").val();
		$.ajax({
			url:"validateServlet",//服务器的地址 @WebServlet("/validateServlet")
			type:"POST",//请求方式
			data:{"userName":userName},//需要传递给后台的数据
			dataType:"text",//希望服务器返回的数据类型 xml html js text
			beforeSend:function(){//发送请求之前执行的函数
				alert("发送验证是否存在请求");
			},
			success:function(data){//响应成功之后执行的函数
				if (data.match("true")) {//证明用户名存在
					$("#result").html("<span style='color:red'>用户名已存在</span>")
				}else{
					$("#result").html("<span style='color:green'>可以使用</span>")
				}
			},
			error:function() {//响应失败执行的函数
                alert("失败");
            }
			
		})
		
	})
   </script>
   
  </body>
</html>
