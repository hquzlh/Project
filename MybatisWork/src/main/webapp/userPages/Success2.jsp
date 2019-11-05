<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/7
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作成功</title>
    <link href="../background/success.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        h1{display: inline;
        }
    </style>
    <script type="text/javascript">
        window.onload = function(){
            var count = 2;
            setInterval(function(){
                count--;
                if(count == 0){
                    window.location.href = "userMain.jsp";//跳转后的页面
                }else{
                    document.getElementById("count-span").innerHTML = count;
                }
            },1000);
        }
    </script>
</head>
<body>
<h1 >操作成功</h1>
<span id="count-span" style="font-size: 14px"></span><h1>秒后自动返回用户界面</h1>
</body>
</html>

