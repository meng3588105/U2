<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
  <script type="text/javascript">
	
		function dianji(){
			$("#dialog").dialog({
				width:"800",
				heigth:"700"
			})
		}		
		
		
	
	
	
</script>
<title>Insert title here</title>
</head>
<body>
	
		欢迎您好！ <c:out value="${users.realName}"></c:out>，<a href="Login.jsp">退出登录</a>
	
		<a id="a1" href="xiaoshou.jsp" target="mainFrame" onClick=dianji()>销售</a>
		<a id="a2" href="sale?method=getAllNews" target="mainFrame" onClick=dianji()>销售信息查询</a>
		<a id="a3" href="kucun.jsp" target="mainFrame" onClick=dianji()> 查看库存</a>
		
	<div id="dialog" title="sssssssssssss" hidden="hidden">
		<iframe src="welcome.jsp" width="700px" height="500px" name="mainFrame" />
	</div>
	
</body>



</html>