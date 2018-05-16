<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <%
        request.setCharacterEncoding("UTF-8");
        //获取请求数据,并去除空格
        String name = request.getParameter("userName").trim();
        String pwd = request.getParameter("pwd").trim();
        boolean valid = false;  //判断用户验证是否成功
        if("meng".equals(name)&&"3588105".equals(pwd)){
             valid = true;
             //设置用户登录信息
             //session.setAttribute("login", name);
             //设置session过期时间
             session.setMaxInactiveInterval(10*60);
        }
        if (valid) {
            request.getRequestDispatcher("admin.jsp")
                .forward(request,response);
        } else {
                response.sendRedirect("form.jsp");
        }
    %>
</body>
</html>