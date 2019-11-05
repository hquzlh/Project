<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/8
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.ucar.training.bean.User" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>用户页面</title>
    <link href="../background/main.css" rel="stylesheet" type="text/css">
    <style type="text/css">
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
        body{
            background-size: 100%;
            background-image:url("../image/i1.jpg");
        }
    </style>
</head>
<body>


<div align="center">
    <h2>用户信息</h2>
    <table>
        <th>用户名</th>
        <th>真实姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>密码</th>
        <th>电话号码</th>
        <th>邮箱地址</th>
        <th>爱好</th>
        <c:forEach items="${applicationScope.userList}" var="user" >
            <tr>
                <td> ${user.uname} </td>
                <td>${user.tname}</td>
                <td>${user.sex}</td>
                <td>${user.age}</td>
                <td>${user.pwd}</td>>
                <td>${user.tel}</td>
                <td>${user.email}</td>
                <td>${user.hobbyStr}</td>
               <%-- <td><c:forEach items="${user.hobby}" var="str">${str}</c:forEach></td>--%>
            </tr>
        </c:forEach>

    </table>
    <a href="adminMain.jsp"><button>返回用户界面</button></a>
    <a href="insertUser.jsp"><button>新增用户</button></a>
    <a href="deleteUser.jsp"><button>继续更改信息</button></a>
</div>
</body>
</html>
