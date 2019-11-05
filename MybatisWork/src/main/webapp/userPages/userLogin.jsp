<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/5
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>普通用户登陆界面</title>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        #wrap {
            height: 719px;
            width: 100%;
            background-image: url(../image/k1.jpg);
            background-size: 100%;
            background-repeat: no-repeat;
            background-position: center center;
            position: relative;
        }
        #head {
            height: 120px;
            width: 100%;
            background-color: #66CCCC;
            text-align: center;
            position: relative;
        }
        #foot {
            width: 100%;
            height: 126px;
            background-color: #CC9933;
            position: relative;
        }
        #wrap .logGet {
            height: 408px;
            width: 368px;
            position: absolute;
            background-color: #FFFFFF;
            top: 20%;
            right: 15%;
        }
        .logC a button {
            width: 100%;
            height: 45px;
            background-color: #ee7700;
            border: none;
            color: white;
            font-size: 18px;
        }
        .logGet .logD.logDtip .p1 {
            display: inline-block;
            font-size: 28px;
            margin-top: 30px;
            width: 86%;
        }
        #wrap .logGet .logD.logDtip {
            width: 86%;
            border-bottom: 1px solid #ee7700;
            margin-bottom: 60px;
            margin-top: 0px;
            margin-right: auto;
            margin-left: auto;
        }
        .logGet .lgD img {
            position: absolute;
            top: 12px;
            left: 8px;
        }
        .logGet .lgD input {
            width: 100%;
            height: 42px;
            text-indent: 2.5rem;
        }
        #wrap .logGet .lgD {
            width: 86%;
            position: relative;
            margin-bottom: 30px;
            margin-top: 30px;
            margin-right: auto;
            margin-left: auto;
        }
        #wrap .logGet .logC {
            width: 86%;
            margin-top: 0px;
            margin-right: auto;
            margin-bottom: 0px;
            margin-left: auto;
        }


        .title {
            color: #FFFFFF;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
            font-size: 36px;
            height: 40px;
            width: 30%;
        }

        .copyright {
            color: #FFFFFF;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
            height: 60px;
            width: 40%;
            text-align:center;
        }


        #foot .copyright .img {
            width: 100%;
            height: 24px;
            position: relative;
        }
        .copyright .img .icon {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;
            background-image: url(../image/i5.jpg);
            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }

        .copyright .img .icon1 {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;
            background-image: url(../image/i6.jpg);
            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }
        .copyright .img .icon2 {
            display: inline-block;
            width: 24px;
            height: 24px;
            margin-left: 22px;
            vertical-align: middle;
            background-image: url(../image/i7.jpg);
            background-repeat: no-repeat;
            vertical-align: middle;
            margin-right: 5px;
        }
        #foot .copyright p {
            height: 24px;
            width: 100%;
        }
        input.submit1{background-color: #cd4606}
        input.reset1{background-color: #cd4606}
        button.fanhui{width: 70px;height: 40px;background-color: #cd4606;margin-left: 40px}
    </style>
</head>

<body>
<div class="header" id="head">
    <div class="title">普通用户空间</div>

</div>

<div class="wrap" id="wrap">
    <div class="logGet">
        <!-- 头部提示信息 -->
        <div class="logD logDtip">
            <p class="p1" align="center">登录</p>
        </div>
        <!-- 输入框 -->
        <div class="lgD">
            <form action="../checkUser" method="post">
                <img src="../image/k2.jpg" width="20" height="20" alt=""/>
                <input type="text" name="uname" id="uname"value=""
                       placeholder="输入用户名" />

                <img src="../image/k2.jpg" width="20" height="20" alt=""/>
                <input type="password" name="pwd1" id="pwd1" value=""
                       placeholder="输入用户密码" />
                <div class="logC">
                    <input type="reset" value="重置" class="reset1" style="color: #000000">
                    <input type="submit" value="登陆"class="submit1" style="color: #000000">

                    <input type="hidden" name="userLogin">
                </div>
            </form>

            <a href="userRegister.jsp"><button class="fanhui">用户注册</button></a>
            <a href="../adminPages/adminRegister.jsp"><button class="fanhui">管理员注册</button></a>
            <a href="../adminPages/adminLogin.jsp"><button class="fanhui">管理员登陆</button></a>
        </div>

    </div>
</div>

<div class="footer" id="foot">
    <div class="copyright">
        <p>-------------------------------</p>
        <div class="img">
            <i class="icon"></i><span>联系邮箱：1074936307@qq.com</span>
        </div>

        <div class="img">
            <i class="icon1"></i><span>联系地址：华侨大学</span>
        </div>

        <div class="img">
            <i class="icon2"></i><span>联系电话：15906091111</span>
        </div>


    </div>

</div>


</body>
</html>

