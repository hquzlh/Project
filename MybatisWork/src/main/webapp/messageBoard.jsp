<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/5
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.ucar.training.bean.User" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>留言板</title>
    <link href="background/messageCss.css" rel="stylesheet" type="text/css">

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
</div>
</body>
</html>

