
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<form action="showallusers.jsp" method="post" class = "one">
  用户名<input type="text" id = "TxtName" name = "TxtName" placeholder="请输入用户名" minlength = "6" maxlength="10"><br>
  密码<input type="password" id = "TxtPass" name = "TxtPass" placeholder="请输入密码"minlength = "6" maxlength="10" ><br>
  性别<input type="text" name = "sex"  name = "sex" placeholder="请输入性别" minlength = "6" maxlength="10"><br>
  <input type="submit" value = "提交">
</form>
</body>
</html>