<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>显示所有的商品列表</h1>
  
  
  <table border="1">
      <tr>
          <td>商品编号</td>
          <td>商品名称</td>
          <td>商品描述</td>
          <td>商品价格</td>
          <td>操作</td>
      </tr>
      
      <c:forEach items="${products}" var="product">
        <tr>
          <td>${product.id}</td>
          <td>${product.name}</td>
          <td>${product.description}</td>
          <td>${product.price}</td>
          <td><a href="javascript:addCart(${product.id})">加入购物车</a></td>
        </tr>
      </c:forEach>
  
  </table>
  <h1><a href="buyServlet?method=findCart">查看购物车</a><h1>
	
</body>
</html>