<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>查看库存</h1>
<form id="form1" action="" method="post" >
	商品名称<select name="a" id="a" onchangge="func()">
			<option value="volvo" selected>请选择</option>  
				
			</select>
		<input type="button" value="查询" id="but">
		</form>
		<div>
		<h1 id ="number"></h1>
		</div>
		


<script src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">


$(document).ready(function (){
			var data1;
		$("#but").click(function (){
			var id=$("#a").val();
			$(data1).each(function (){
				if(id==this.id){
					$("#number").html("");
					$("#number").html(this.quantity)
				}
			})
		})
	
	
	
	
	
		$.ajax({
			url:"Product?method=chazhao",//需要提交服务器的地址
			type:"get",		
			dataType:"json",
			success:function(data){//回调函数
				
			$("#a").html("");
				data1=data;
				$(data).each(function(){
					$("#a").append(
							 "<option value=\""+this.id+"\" >"+this.productName+"</option>"  
					)	
					
					
				})
			}
		})
		
		
	
	
	
	
})





</script>
</body>

</html>