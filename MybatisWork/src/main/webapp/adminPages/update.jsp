<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/6
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改用户信息</title>
    <meta charset="UTF-8">
    <script type="text/javascript" charset="utf-8">
        //检验用户名规范

        //检验年龄规范
        function checkage() {
            var age=document.getElementById("age").value;
            var span4=document.getElementById("ageSpan")
            var reg4=/[1-9]\d*/;
            if(age==""||age==null){
                span4.innerHTML="年龄不能为空";
                span4.style.color="red";
                return false;
            }else if(reg4.test(age)&&(1<=age&&age<=150)){
                span4.innerHTML="很年轻呀"
                span4.style.color="green";
                return true;
            }else {span4.innerHTML="格式错误"
                span4.style.color="red"
                return false;}
        }
        //检验第二次输入的密码是否和第一次相同
        function checkpwd2() {
            var pwd1=document.getElementById("pwd1").value;
            var pwd2=document.getElementById("pwd2").value;
            var span2=document.getElementById("pwd2Span");
            if(pwd2==""||pwd2==null){
                span2.innerHTML="*密码不能为空";
                span2.style.color="red";
                return false;
            }else if(pwd1==pwd2){
                span2.innerHTML="确认密码一致"
                span2.style.color="green";
            } else{span2.innerHTML="密码输入不一致"
                span2.style.color="red";
                return false;
            }

            return  false}
        //检验密码
        function checkpwd1() {
            var pwd1=document.getElementById("pwd1").value;
            var reg2=/[a-zA-Z0-9]{6,18}/;
            var span1=document.getElementById("pwd1Span")
            if(pwd1==""||pwd1==null){
                span1.innerHTML="*密码不能为空";
                span1.style.color="red";
                return false;
            }else if(reg2.test(pwd1)){
                span1.innerHTML="密码可用"
                span1.style.color="green";
            } else{span1.innerHTML="密码不符合规则"
                span1.style.color="red";
                return false;}
            checkpwd2();
            return false
        }
        //检验爱好选择
        function checkhy() {
            var hys=document.getElementsByName("hobby");
            var span3=document.getElementById("hySpan")
            for (var i=0;i<hys.length;i++){
                if(hys[i].checked){
                    span3.innerHTML="爱好选择成功"
                    span3.style.color="green";
                    return true;
                }}
            span3.innerHTML="至少选择一种爱好";
            span3.style.color="red";
            return false;
        }
        //检验是否都符合要求
        function checksub() {
            checkhy();
            checkpwd2();
            checkpwd1();
            checkage();


            return ((((((checkage()&&checkname())&&checkpwd1())&&checkpwd2())&&checktext())&&checksub()));

        }
    </script>
    <link href="../registerCss.css" rel="stylesheet" type="text/css">
</head>
<body >
<h2 align="center">用户信息修改</h2>
<div align="center">
    <form action="../updateSer" method="post" onsubmit=" return checksub()">
        <table align="center">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="uname" id="uname" value="${requestScope.updateUser.uname}"onblur="checkname()" style="pointer-events: none">
                    <span id="unameSpan">待修改的用户</span></td>

            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input type="text" name="tname" value="${requestScope.updateUser.tname}" id="tname"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><label>男<input type="radio" name="sex" value="男" ${requestScope.updateUser.sex == '男'?'checked':''}>
                    女<input type="radio" name="sex" value="女" ${requestScope.updateUser.sex == '女'?'checked':''}></label></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value="${requestScope.updateUser.age}"  id="age" onblur="checkage()">
                    <span id="ageSpan">输入正确年龄</span></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="pwd1" value=""id="pwd1"  onblur="checkpwd1()">
                    <span id="pwd1Span">输入密码长度为6-18，并且只能由数字和字母组成</span></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="pwd2" value="" id="pwd2" onblur="checkpwd2()">
                    <span id="pwd2Span">再次输入密码</span></td>
            </tr>
            <tr>
                <td>电话号码</td>
                <td><input type="text" name="tel" value="${requestScope.updateUser.tel}"></td>
            </tr>
            <tr>
                <td>邮箱地址</td>
                <td><input type="text" name="email" value="${requestScope.updateUser.email}"></td>
            </tr>
            <tr>
                <td>爱好</td>
                <td><label><input type="checkbox" name="hobby" value="撩妹"  onclick="checkhy()" }>撩妹</label>
                    <label><input type="checkbox" name="hobby" value="写代码" onclick="checkhy()"}>写代码</label>
                    <label><input type="checkbox" name="hobby" value="篮球" onclick="checkhy()"}>篮球</label>
                    <label><input type="checkbox" name="hobby" value="足球" onclick="checkhy()"}>足球</label>
                    <span id="hySpan">选择你的爱好</span></td>
            </tr>
            <tr>
                <td>个人签名</td>
                <td><textarea cols="25" rows="2" name="text" id="text" onclick="checktext()"></textarea>
                    <span id="areaSpan">填写文本框</span></td>
            </tr>

        </table>
        <input type="submit"value="确认修改" class="button" style="font-size: 14px">
        <input type="reset" value="重置" class="button">
        <input type="hidden" name="userRegister">
    </form>
    <a href="adminPages/adminMain.jsp"><button>返回上一页</button></a>
</div>
</body>
</html>
