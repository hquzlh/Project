<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/6
  Time: 8:49
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
</head>
<body>


<div align="center">
    <h2>管理员信息</h2>
    <table>
        <th>用户名</th>
        <th>真实姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>密码</th>
        <th>电话号码</th>
        <th>邮箱地址</th>
        <th>爱好</th>
        <c:forEach items="${applicationScope.adminList}" var="admin" >
            <tr>
                <td> ${admin.uname} </td>
                <td>${admin.tname}</td>
                <td>${admin.sex}</td>
                <td>${admin.age}</td>
                <td>${admin.pwd}</td>>
                <td>${admin.tel}</td>
                <td>${admin.email}</td>
                <td>${admin.hobbyStr}</td>
                <%--<td><c:forEach items="${admin.hobby}" var="str">${str}</c:forEach></td>--%>
            </tr>
        </c:forEach>


    </table>
</div>
</body>
</html>