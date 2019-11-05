<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/6
  Time: 10:44
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
    <script type="text/javascript" charset="UTF-8">
        function  deleteUser(uname) {
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
                if (ajax.readyState == 4) {
                    alert(result);
                    window.location.reload();
                }
            }
            //发送请求
            ajax.open("get","/deleteAjax?uname="+uname);
            ajax.send(null)
            //获取元素对象
        }
    </script>
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
        <th>操作</th>
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
                <td>
                    <ul>
                        <li><button onclick="deleteUser(${user.uname})">删除</button></li>
                        <a href="../updateAjax?uname=${user.uname}&tname=${user.tname}&sex=${user.sex}&tel=${user.tel}&email=${user.email}&age=${user.age}"><button>更新</button></a>
                    </ul>
                </td>
            </tr>
        </c:forEach>

    </table>
    <a href="adminMain.jsp"><button>返回上一页</button></a>
</div>
</body>
</html>
