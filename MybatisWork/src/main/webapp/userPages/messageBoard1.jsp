<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/8
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.ucar.training.bean.User" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>留言板</title>
    <link href="../background/messageCss.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        body{
            background-size: 100%;
            background-image: url("../image/i1.jpg");
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
    <h2>留言板</h2>
    <table>
        <th>用户名</th>
        <th>留言内容</th>
        <th>时间</th>
        <c:forEach items="${applicationScope.boardList}" var="mess" >
            <tr>
                <td>${mess.name}</td>
                <td>${mess.message}</td>
                <td>${mess.date}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="writeMess.jsp"><button>继续编写留言</button></a>
    <a href="userMain.jsp"><button>返回用户界面</button></a>
</div>
</body>
</html>