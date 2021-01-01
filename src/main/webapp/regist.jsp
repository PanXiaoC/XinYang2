
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Regist page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <style type="text/css">
        span{
            color:red;
        }
    </style>

    <!-- <script type="text/javascript" src="js/outer.js"></script> -->

    <script type="text/javascript" src="static/jquery-3.3.1.min.js"></script>

</head>

<body>
    <span style="color:red;">${registDefeat}</span>
    <form action="${pageContext.request.contextPath}/regist" method="post">
        用户名称:<input name="username" id="username" onblur="ajaxSubmit()"><span id="state"></span> <br/>
        用户密码:<input type="userpass" name = "userpass"><br>
        用户性别:男<input type="radio" value="男" checked name="sex">
                女<input type="radio" value="女" checked name="sex"><br>
        <input type="submit" id="submit" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="取消">
    </form>
    已有账号？<a href="/login">登录</a>
</body>

<script type="text/javascript">
    function ajaxSubmit(){
        alert("你好")
        $.ajax({
            type:"post",
            url:"/ocp/check?username="+$("#username").val(),
            data:null,
            success:function (msg) {
                //alert(msg);
                if (msg !="√") {
                    $("#state").html("<font color='red'>用户名已存在！</font>");
                    $("#submit").prop("disabled", true);
                }else{
                    $("#state").html("<font color='green'>√</font>");
                    $("#submit").prop("disabled", false);
                }

            },
            error:function () {
                console.log("错误回调函数");
            }
        })
    }
</script>

</html>

