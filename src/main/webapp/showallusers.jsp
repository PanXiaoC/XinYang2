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
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		#header{margin-left:1100px;}
		table{width: 100%}
		table,tr,th{border: 1px solid gray;border-collapse:collapse;  }
		#error{color:red;}
		a{text-decoration: none;}
	</style>
	
	<!-- <script type="text/javascript" src="js/outer.js"></script> -->
	
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

  </head>
  
  <body>
    	<span id="header">
    		<label title="点击修改密码">${user.username},先生/女士</label>,
    			<a href="/ocp/logout">【退出】</a>
    	</span>
    <hr/>	
    <table>
    		<thead>
    			<tr><th>用户编号</th><th>用户姓名</th><th>用户密码</th><th>用户性别</th><th>操作</th></tr>
    		</thead>
    		<tbody>
    		<c:forEach items="${user2}" var="user" varStatus="list">
    			<tr>
	    			<th>${user.userid}</th>
	    			<th>${user.username}</th>
	    			<th id="${user.userid}">${user.userpass}</th>
	    			<th>${user.sex}</th>
	    			<th>
	    				<button onclick="modify(${user.userid},this)">修改密码</button>&nbsp;&nbsp;&nbsp;&nbsp;
	    				<button onclick="removeUserById(${user.userid},this)">删除</button>
	    			</th>
    			</tr>
    		</c:forEach>
    		</tbody>
    	</table>
    		<center>
    		当前第${pageInfo.pageNum}页/总共${pageInfo.pages}页,
    		<a href="user/getAllUsers?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}">上一页</a>  
    		<a href="user/getAllUsers?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}">下一页</a>  
    		&nbsp;&nbsp;查看第<input size="2" onblur="quick()" placeholder="${pageInfo.pageNum}">页 
    	</center>
  </body>
  
  <script type="text/javascript">
  	//ajax修改
		function modify(userid,object){
				/* alert(userid+"   "+object); */
			 var newPass=prompt("请输入新密码");
			 $.ajax({
  				type:"post",
  				url:"/ocp/modify?userid="+userid+"&password="+newPass,
  				data:null, 
  				success:function(msg){
  					/*  alert(msg); */ 
  					if(msg>0){
  					//js方式
  					//object.parentNode.parentNode.cells[2].innerHTML=newPass;
  					/* alert("jquery"); */
  					$("#"+userid).html(newPass);
  					}
  				}
  			}); 
		} 
		
		
		//ajax删除
		 function removeUserById(userid,object){
			  $.ajax({
  				type:"post",
  				url:"user/del?userid="+userid,
  				data:null, 
  				success:function(msg){
  				/* alert(msg); */
  					if(msg>0){
  						object.parentNode.parentNode.remove();
  					}
  				}
  			});
		} 
		
		function quick(){
			var $pageNum=$("input").val();
			if(!isNaN($pageNum)){
				location.href="user/getAllUsers?pageNum="+$pageNum+"&maxPage=${pageInfo.pages}";
			}else{
			
				$("input").val(${pageInfo.pageNum});
			}
			
		}
  
  </script>
  
</html>
