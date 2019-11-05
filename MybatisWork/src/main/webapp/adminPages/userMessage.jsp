<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/7
  Time: 8:15
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
                <%--<td><c:forEach items="${user.hobby}" var="str">${str}</c:forEach></td>--%>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
