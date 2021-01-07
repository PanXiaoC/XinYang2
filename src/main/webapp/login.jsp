<%--
  Created by IntelliJ IDEA.
  User: PanXi
  Date: 2020/12/31
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <meta name="keywords" content="Web App Login Screen Responsive Templates, Iphone Compatible Templates, Smartphone Compatible Templates, Ipad Compatible Templates, Flat Responsive Templates"/>
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!--webfonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!--/webfonts-->
    <style>
        span{
            color: yellow;
        }
    </style>
</head>
<body>
<!--start-main-->
<h1>OCP全渠道数字平台 | 登录</h1>
<div class="login-box">
    <form action="/login" method="post" id="login_form" οnsubmit="return checkForm()">
        <input type="text" id="user" name="pass_usern" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" placeholder="请输入用户名" ><span >${loginerror}</span>
        <input type="password" id="pass" name = "pass_pass" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" placeholder="请输入密码">
        <input type="hidden" name="pass_pass" id="md5_pwd" value='' />
        <div class="check-box">
            <div class="slideThree">
                <input type="checkbox" value="None" id="slideThree" name="check" />
                <label for="slideThree"> </label>
            </div>
        </div>
        <div class="remember"><p>记住密码</p></div>
        <div class="btn" onclick="checkForm()"><input type="submit" value="登录" ></div>
    </form>

</div>
<!--//End-login-form-->
<!--start-copyright-->
<div class="copy-right">
    <p>版权所有： <a href="http://www.chinamacro.cn/">广东万家乐燃气具有限公司</a> ©Copyright 2016-2020 粤ICP备05025313号</p>
</div>
<!--//end-copyright-->
<script>
    function checkForm(){
        var input_pwd= document.getElementById('input_pwd');
        var md5_pwd= document.getElementById('md5_pwd');
        md5_pwd.value= toMD5(input_pwd.value);
        //可在此修改input
        xmlhttp.open("POST","/ocp/login",toMD5);
        //进行下一步
        return true;
    }
</script>
</body>
</html>
