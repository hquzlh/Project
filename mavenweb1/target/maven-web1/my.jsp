<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/1
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function  getData() {
            var showdiv=document.getElementById("showdiv");
            showdiv.innerHTML="看不见海了难受"
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
