<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/7
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>照片墙</title>
    <style type="text/css">
        body{
            background: rgba(17, 17, 17, 0.1);
        }
        h1{
            text-align: center;
            text-shadow: 2px 2px 10px  #6ce893;
        }
        .container{
            width: 960px;
            height: 450px;
            margin: 60px auto;
            position: relative;

        }
        img{
            padding:10px 10px 15px;background: rgba(104, 147, 160, 0.55);border: 3px solid #dddddd;position: absolute;top:50px;
            left:200px;transform: rotate(30deg);transition: 1s}
        img:hover{transform: rotate(0deg);transform: scale(0.5);box-shadow: 10px 10px 15px #80dd44
        }
        .p1{
            left: 100px;
            top:30px;
            height: 200px;
            width: 200px;
        }
        .p2{
            left: 350px;
            top:30px;
            transform: rotate(-50deg);
            height: 200px;
            width: 200px;
        }
        .p3{
            left: 520px;
            top:30px;
            transform: rotate(50deg);
            height: 200px;
            width: 200px;
        }
        .p4{
            left: 660px;
            top:30px;
            transform: rotate(-50deg);
            height: 200px;
            width: 200px;
        }
        .p5{
            left: 100px;
            top:200px;
            transform: rotate(50deg);
            height: 200px;
            width: 200px;
        }
        .p6{
            left: 350px;
            top:210px;
            transform: rotate(60deg);
            height: 200px;
            width: 200px;
        }
        .p7{
            left: 550px;
            top:210px;
            transform: rotate(-50deg);
            height: 300px;
            width: 300px;
        }
        body{
            background-image: url("image/k8.jpg");
            background-size: 100%;
        }
    </style>
</head>
<body>
<h1>照片墙</h1>
<div class="container">
    <img class="p1" src="image/c1.jpg">
    <img class="p2" src="image/c2.jpg">
    <img class="p3" src="image/c3.jpg">
    <img class="p4" src="image/c4.jpg">
    <img class="p5" src="image/c5.jpg">
    <img class="p6" src="image/c7.jpg">
    <img class="p7" src="image/c6.jpg">

</div>

</body>
</html>
