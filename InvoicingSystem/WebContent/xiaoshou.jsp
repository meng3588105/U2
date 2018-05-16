<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>添加销售</h3>
	
	商品名称<select>
  		<option value ="volvo">aaaaa</option>
  		<option value ="saab">bbbb</option>
  		<option value="opel">cccc</option>
  		<option value="audi">ddddd</option>
		</select>
		<form id="myForm" action="Login?method=Login" method="post">
			销售单价：<input type="text"name="price" ><br/>
			销售数量<input type="text"name="num" ><br/>
		</form>
	
</body>
</html>