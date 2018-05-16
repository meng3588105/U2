<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<select id="one">
  <option>请输入省份</option>
</select>
<select id="two">
  <option>请输入市</option>
</select>
<select id="three">
  <option>请输入区</option>
</select>
<script type="text/javascript">
  var oone=document.getElementById("one");
  var otwo=document.getElementById("two");
  var three=document.getElementById("three");
  var str='';
  otwo.disabled=true;
  three.disabled=true;
  var arr1=[{"id":"1","value":"北京"},{"id":"2","value":"上海"},{"id":"3","value":"重庆"},{"id":"4","value":"天津"},{"id":"5","value":"山东"}];
  for(var i=0;i<arr1.length;i++){
    str+="<option value="+arr1[i].id+">"+arr1[i].value+"</option>"
  }
  oone.innerHTML=str;
  var arr2 = {
    '1':['101@北京'],
    '2':['201@上海'],
    '3':['301@重庆'],
    '4':['401@天津'],
    '5':['501@济南','502@青岛']  };
  oone.onchange=function(){
    var val=this.value;
    var arrA = arr2[val];
    var str1='<option>请输入市</option>';
    for(var j=0;j<arrA.length;j++){
      var aaa=arrA[j].split('@');
      str1+="<option value="+aaa[0]+">"+aaa[1]+"</option>"
    }
    otwo.innerHTML=str1;
    otwo.disabled=false;
    three.innerHTML='<option>请输入区</option>';
    three.disabled='disabled';
  }
  var arr3 = {
    '101':['朝阳区','昌平区'],
    '201':['宝山区','浦东区'],
    '301':['不知道'],
    '401':['真的不知道'],
    '501':['市中区','历下区','槐荫区'],
    '502':['市南区','市北区','崂山区']  };
  otwo.onchange = function(){
    var val=this.value;
    console.log( this.value);
    var str2='<option>请输入区</option>';
    console.log(val)
    for(var l=0;l<arr3[val].length;l++){
      str2+="<option >"+arr3[val][l]+"</option>"
    }
    three.innerHTML=str2;
    three.disabled=false;
  }
</script>
</body>
</html>