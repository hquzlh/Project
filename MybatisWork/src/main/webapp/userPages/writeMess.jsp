<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/6
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编写留言板</title>
    <style type="text/css">
        h2{
            text-align: center;
            margin: 50px auto;
            font-family: "League-Gothic", Courier;
            font-size: 50px;
            text-transform: uppercase;
            color: #fff;
            text-shadow: 0 0 20px #fefcc9, 10px -10px 30px #feec85, -20px -20px 40px #ffae34, 20px -40px 50px #ec760c, -20px -60px 60px #cd4606, 0 -80px 70px #973716, 10px -90px 80px #451b0e;
        }
        body{
            background-image:url("../image/j3.jpg");background-size: 100%
        }
        button {
            color: midnightblue;
            background: purple;
            border: 1px cornflowerblue solid;
            padding: 5px 10px;
            border-radius: 2px;
            font-weight: bold;
            font-size: 9pt;
            outline: none;
            height: 40px;
            width: 100px;
        }
        input {
            color: midnightblue;
            background: red;
            border: 1px cornflowerblue solid;
            padding: 5px 10px;
            border-radius: 2px;
            font-weight: bold;
            font-size: 9pt;
            outline: none;
            width: 60px;
        }
        textarea{
            outline:none;
            resize:none;
            background:transparent;
            border-color:orangered;
            overflow-y:hidden;
            overflow-x:hidden;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>输入你的留言信息</h2>
<form action="../boardSer" method="get">
<textarea name="mess1" id="mess1" rows="8" cols="60"></textarea>
    <input type="submit" value="发布">
</form>
<a href="userMain.jsp"><button>返回用户界面</button></a>
</div>
</body>
</html>
