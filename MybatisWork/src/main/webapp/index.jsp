<%@ page language="java"  pageEncoding="UTF-8"%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>首页</title>
  <style type="text/css">
   /* body{
      background-image: url("img3.jpg");
    }*/
   button {
     background: #3498db;
     background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
     background-image: -moz-linear-gradient(top, #3498db, #2980b9);
     background-image: -ms-linear-gradient(top, #3498db, #2980b9);
     background-image: -o-linear-gradient(top, #3498db, #2980b9);
     background-image: linear-gradient(to bottom, #3498db, #2980b9);
     -webkit-border-radius: 28px;
     -moz-border-radius: 28px;
     border-radius: 28px;
     text-shadow: 14px -10px 1px #666666;
     font-family: Arial;
     color: #100c0c;
     font-size: 11px;
     padding: 12px 30px 12px 30px;
     text-decoration: none;
   }

   button:hover {
     background: #2980b9;
     background-image: -webkit-linear-gradient(top, #2980b9, #3498db);
     background-image: -moz-linear-gradient(top, #2980b9, #3498db);
     background-image: -ms-linear-gradient(top, #2980b9, #3498db);
     background-image: -o-linear-gradient(top, #2980b9, #3498db);
     background-image: linear-gradient(to bottom, #2980b9, #3498db);
     color: #100c0c;
     text-decoration: none;
   }
    body{
      background-image: url("image/i5.jpg");
      background-size: 100%;
    }
  </style>
</head>

<body>
<div align="center">
  <table>
    <h2>欢迎使用</h2>
    <td></td><a href="userPages/userRegister.jsp" >
    <button>普通用户注册</button>
  </a>
    <a href="adminPages/adminRegister.jsp" >
      <button>管理员注册</button>
    </a>
    </td>
    <td>
      <a href="userPages/userLogin.jsp">
        <button>普通用户登陆</button>
      </a>
    </td>
    <td>
      <a href="adminPages/adminLogin.jsp">
        <button>管理员登陆</button>
      </a>
    </td>
  </table>
</div>
</body>
</html>
