<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>普通用户登陆页面</title>
    <style type="text/css">
        /*  body{
              background-image: url("img3.jpg");

          }*/
        input{
            font-size: 20px;
            height: 30px;

        }
        body{
            background-image: url("../image/i5.jpg");
            background-size: 100%;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>普通用户登陆页面</h2>
    <form action="../checkUser" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="uname" id="uname"value=""></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="pwd1" id="pwd1" value=""></td>
            </tr>
        </table>
        <input type="reset" value="重置">
        <input type="submit" value="登陆">
        <input type="hidden" name="userLogin">
    </form>
    <a href="../index.jsp" >
        <button>返回首页</button>
    </a>
</div>
</body>
</html>



管理员
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登陆页面</title>
    <style type="text/css">
        /*  body{
              background-image: url("img3.jpg");

          }*/
        input{
            font-size: 20px;
            height: 30px;

        }
        body{
            background-image: url("../image/i5.jpg");
            background-size: 100%;
        }
    </style>
</head>
<body >
<div align="center">
    <h2>管理员登陆页面</h2>
    <form action="../checkAdmin" method="post">
        <table>
            <tr>
                <td>管理员账号:</td>
                <td><input type="text" name="uname" id="uname"value=""></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="pwd1" id="pwd1" value=""></td>
            </tr>
        </table>
        <input type="reset" value="重置">
        <input type="submit" value="登陆">
        <input type="hidden" name="adminLogin">
    </form>
    <a href="../index.jsp" >
        <button>返回首页</button>
    </a>
</div>
</body>
</html>