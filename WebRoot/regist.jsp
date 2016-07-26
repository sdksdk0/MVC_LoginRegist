<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/calendar.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/css/calendar.js"></script>
  </head>
  
  <body>
  	
    <form action="${pageContext.request.contextPath}/servlet/RegistServlet" method="post">
    	<table border="1" width="638">
    		<tr>
    			<td>用户名：</td>
    			<td>
    				<input type="text" name="username" value="${formBean.username}"/>${formBean.errors.username}
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td>
    				<input type="password" name="password" value=""/>${formBean.errors.password}
    			</td>
    		</tr>
    		<tr>
    			<td>重复密码：</td>
    			<td>
    				<input type="password" name="repassword" value=""/>${formBean.errors.repassword}
    			</td>
    		</tr>
    		<tr>
    			<td>邮箱：</td>
    			<td>
    				<input type="text" name="email" value="${formBean.email}"/>${formBean.errors.email}
    			</td>
    		</tr>
    		<tr>
    			<td>生日：</td>
    			<td>
    				<input type="text" id="birthday" name="birthday" readonly="readonly" onclick="return showCalendar('birthday', 'y-mm-dd');" value="${formBean.birthday}"/>${formBean.errors.birthday}
    			</td>
    		</tr>
    	</table>
    	<input type="submit" value="注册"/>
    </form>
  </body>
</html>
