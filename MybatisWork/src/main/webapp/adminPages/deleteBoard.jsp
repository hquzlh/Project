<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/7
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.ucar.training.bean.User" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>删除留言</title>
    <script type="text/javascript" charset="UTF-8">
        function  deleteMess() {
            //创建ajax引擎对象
            var ajax
            if(window.XMLHttpRequest){//火狐
                ajax=new XMLHttpRequest();
            }else if(window.ActiveXObject){//ie7以下
                ajax=new ActiveXObject("Msxm12.XMLHTTP");
            }
            //复写函数
            ajax.onreadystatechange=function () {
                var result = ajax.responseText;
                //获取响应内容
            }
            //发送请求
            ajax.open("get","/delMessAjax?name="+name+"&date="+date);
            ajax.send(null)
            //获取元素对象

        }
    </script>
    <link href="../background/main.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        body{background-image: url("../image/k3.jpg");background-size: 100%}
        ul{
            list-style-type: none;
        }
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

<div align="center">
    <h2>删除留言</h2>
    <table>
        <th>用户名</th>
        <th>留言内容</th>
        <th>时间</th>
        <th>操作</th>
        <c:forEach items="${applicationScope.boardList}" var="mess" >
            <tr>
                <td>${mess.name}</td>
                <td>${mess.message}</td>
                <td>${mess.date}</td>
                <td>
                <ul>
                    <%--<li><input type="button" value="删除" onclick="window.location.href='${"http://10.100.220.63:8843/delMessAjax?name="}${mess.name}${"&date="}${mess.date}'"/></li>--%>
                    <a href="../delMessAjax?name=${mess.name}${"&date="}${mess.date}"><button>删除</button></a>
                </ul>
            </td>
            </tr>
        </c:forEach>
    </table>
    <a href="adminMain.jsp"><button>返回上一页</button></a>
</div>
</body>
</html>