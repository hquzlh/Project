<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/8/6
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户主界面</title>
    <link href="../mainCss.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="top">
    <div id="image">
        <img src="../image/i2.jpg" width="250px" height="150px" style="margin-top: 32px">
    </div>
    <div id="topMenu">
        <ul class="menu">
        <li><a href="../photo.jsp" target="mainFrame"><button>相册</button></a></li>
            <li><a href="../messageBoard.jsp" target="mainFrame"><button>留言板</button></a></li>
    </ul></div>


</div>
<div  style="display:inline-block" id="left">
    <div id="leftMenu">
<ul>
    <li>
        <a href="userMess.jsp" target="mainFrame" ><button>用户信息</button></a>
    </li>
    <li><a href="writeMess.jsp"><button>编写留言</button></a></li>
    <li><a href="fileUpload.jsp"><button>文件上传</button></a></li>
    <li><a href="fileDownload.jsp"><button>文件下载</button></a></li>
    <li><a href="userLogin.jsp"><button>返回登陆页面</button></a></li>
</ul>
    </div>

</div>
<div style="display:inline-block" id="main" >
    <iframe name="mainFrame" width="100%" height="98%" frameborder="0" scrolling="no" marginheight="0"></iframe>

</div>
</body>
</html>
