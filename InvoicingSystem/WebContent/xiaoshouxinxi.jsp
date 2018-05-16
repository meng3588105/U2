<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
	<!-- <link rel="stylesheet" href="css/public.css" type="text/css"></link> -->
	<!-- <link rel="stylesheet" href="css/style.css" type="text/css"></link> -->
	<script type="text/css">
	table tr:nth-child(2n){background-color:#fbc9a7}

	</script>
  </head>
  
  <body>
   <table id="td"  width="50%" border="1" align="center">
     <!-- <caption><h1 style="height: 50px;line-height5:0px;border: 1px"></h1></caption> -->
     
    <!-- <thead > -->

    <tr class="t_head">
          
		  <th>单价</th>
		  <th>数量</th>
		  <th>总价</th>
		  <th>销售日期</th>
		  <th>销售员</th>
		  <th>商品id</th>
    </tr>
   <!--  </thead> -->

    
      <tbody id="list-content">
      
      </tbody>
</table>
<div  class="pagination" id="pagination"></div>





<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>

<script type="text/javascript">
  load(0);  //默认初始化
    /*点击查询的触发事件*/
   function  load(pageNum) {
       $.ajax({
           url: "test",  //需要提交的服务器地址
           type: "post",  //请求的方式
           data: {"pageNum": pageNum},  //传递给服务器的参数
           success: function (data) {  //回调函数
             var data=$.parseJSON(data);
               //清空数据
               $("#list-content").html('');
               //追加数据  data.list需要遍历的集合  list必须是pageInfo中的属性名
               $.each(data.list, function (i, news) {
                   //一个dom就是一个用户对象
                   $("#list-content").append("<tr class='t_head'>"
         									
		 										+"<th>"+news.price+"</th>"		
		 										+"<th>"+news.quantity+"</th>"
		  										+"<th>"+news.totaLprice+"</th>"
		  										+"<th>"+news.saleDate+"</th>"
		  										+"<th>"+news.userId+"</th>"
		  										+"<th>"+news.productId+"</th>"
    											+"</tr>");
               });

               //渲染分页  总记录数  当前页码  每页数据量
               $('#pagination').pagination(data.total, {
                   current_page:pageNum,//当前第几页
                   items_per_page: data.pageSize,
                   callback: load,  //回调函数
                   num_edge_entries: 2,
                   load_first_page: true,
                   prev_show_always:false,
                   next_show_always:false,
                   prevCls:'prev',		//上一页class
                   nextCls:'next',		//下一页class
                   prev_text: '上一页',
                   next_text: '下一页'
               });
           }
       });
   };



</script>

  </body>
</html>
