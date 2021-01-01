<%--
  Created by IntelliJ IDEA.
  User: PanXi
  Date: 2020/12/10
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        span{
            color: red;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post" >
    用户名<input type="text" id = "TxtName" name = "username" placeholder="请输入用户名" ><span >${loginerror}</span><br>
    密码<input type="password" id = "TxtPass" name = "userpass" placeholder="请输入密码" ><br>
    <input type="submit" value = "提交">&nbsp;&nbsp;&nbsp;
    <input type="reset" value = "数据">
</form>
还没有账号？ <a href="regist_page">注册</a>
</body>
</html>
