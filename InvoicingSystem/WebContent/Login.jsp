<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
    .error{
        color: red;
    }
</style>
<body>
	<div>
	<h1>小型进销存系统</h1>
	<form id="myForm" action="Login?method=Login" method="post">
			用户名：<input type="text"name="userName" ><br/>
    		密  码：<input type="text" name="password" ><br/>
	 <input value="登录" type="submit">
	</form>
	
	</div>
<script src="js/jquery-1.8.3.js"></script>
<script src="js/jquery.validate.js"></script>
	
	<script>
    $(function(){
        $("#myForm").validate({
//            验证的规则  需要对form表单中的那些元素做验证
            rules:{
                //验证用户名不能为空
                userName:{
                    required:true,
                },
                //验证密码不能为空，
                password:{
                    required:true,
                },
               },
            messages:{
                userName:{
                    required:"用户名必填！",
                },
                //验证密码不能为空，最短6位，最长10位
                password:{
                    required:"密码必填！",
                }
                
            },

            //文本框失去焦点立即验证
            onfocusout:function(e){
                $(e).valid();
            }

      
            });
        
        
    })
     </script>
</body>
</html>