<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>  
<!-- 	和session对象一样，application存储的是对象类型而不是普通的数值类型。
		此处调用了application对象中的getAttribute()方法来获取前一个页面所存储的信息，
		并把读取出的计数值加一，然后重新存储在application当中去。
 -->
 <!--	 当关闭以上运行的两个浏览器窗口，再多次交替地打开和关闭getappattr.jsp窗口，
 		会看到计数值一直在递增，只用tomcat服务不关闭。
 		而session对象存储的信息会随着窗口的关闭而释放。
  -->
<br>获得用户名：<%=application.getAttribute("name")%>  
<br>计数值：  
<%  
    //将保存在application中的关键字为counter的字符串对象取出，然后强制转化成整数型  
    int mycounter = Integer.valueOf(application.getAttribute("counter").toString()).intValue();  
    out.println(mycounter);  
    //将数值加一，然后用新的值来更新保存再application中的counter对象  
    application.setAttribute("counter",Integer.toString(mycounter+1));  
%>  
</body> 
</html>