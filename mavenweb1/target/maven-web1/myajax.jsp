<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/1
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function  getData() {
            //创建ajax引擎对象
            var ajax
            if(window.XMLHttpRequest){//火狐
                ajax=new XMLHttpRequest();
            }else if(window.ActiveXObject){ie7以下
                ajax=new ActiveXObject("Msxm12.XMLHTTP");
            }
            //复写函数
            ajax.onreadystatechange=function () {
                //获取响应内容
                if(ajax.readyState==4){
                var result=ajax.responseText;
                //eval(result)
                alert(obj.name);
                var showdiv=document.getElementById("showdiv");
                showdiv.innerHTML=result;
            }}
            //发送请求
            ajax.open("get","ajax");
            ajax.send(null)
            //获取元素对象

        }
    </script>
    <style type="text/css">
        #showdiv{
            border:solid 1px;
            width: 200px;
            height: 100px ;

        }
    </style>
</head>
<body>
<h3>欢迎登陆峡谷</h3>
<hr>
<input type="button" value="测试"  onclick="getData()">
<div id="showdiv"></div>
</body>
</html>