<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/6
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆失败</title>
    <style type="text/css">
        h1{display: inline;
        }
        body{
            background-image: url("image/j4.jpg");
            background-size: 500px,800px;
            background-position: center 0px;
            background-attachment: fixed;
            background-repeat: no-repeat;
        }

    </style>
    <script type="text/javascript">
        window.onload = function(){
            var count = 3;
            setInterval(function(){
                count--;
                if(count == 0){
                    window.location.href = "index.jsp";//跳转后的页面
                }else{
                    document.getElementById("count-span").innerHTML = count;
                }
            },1000);
        }
    </script>

</head>
<body>
<h1 >对不起，操作有误.</h1>
<span id="count-span" style="font-size: 15px"></span><h1>秒后自动返回主界面</h1>
</body>
</html>
