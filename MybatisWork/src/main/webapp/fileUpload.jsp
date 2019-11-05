<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/7
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <style type="text/css" >
        button {
            color: midnightblue;
            background: deepskyblue;
            border: 1px cornflowerblue solid;
            padding: 5px 10px;
            border-radius: 2px;
            font-weight: bold;
            font-size: 11pt;
            outline: none;
            width: 90px;
            height: 45px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<h1>文件上传</h1>
<form action="../upload" method="post" enctype="multipart/form-data">
    上传文件：<input type="file" name="newfile"><br>
    <input type="hidden" name="userfile">
    <input type="submit" value="上传">
</form>
<a href="index.jsp"><button>返回主界面重新登陆</button></a>
</body>
</html>
