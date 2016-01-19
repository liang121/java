<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Employees' Management System</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="http://fonts.googleapis.com/css?family=Crimson+Text" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=Allerta" rel="stylesheet" type="text/css">
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="assets/styles/login.css">
  </head>
  
  <body>
  	<div id="back">
		<div id="loginDiv" >
			<form id="login" action="login" method="post">
				<span style="color:black;font-size:30px">Login</span><hr>
				<span style="color:red">${error}</span>
				<input type="text" id="userName" class="form-control" placeholder="username:"   name="userName" ><br>
				<input type="password" id="password" class="form-control" placeholder="password:"  name="password"><br>
				<button type="submit" class="btn btn-info" style="width:180px;float:left"><span style="font-family: 'Crimson Text',Georgia, Times, serif; font-size: 20px;">Login</span></button>
				<button type="reset" class="btn btn-info" style="width:180px;float:right"><span style="font-family: 'Crimson Text',Georgia, Times, serif; font-size: 20px;">Reset</span></button>
			</form>
			<script type="text/javascript">

			</script>
		</div>
	</div>	
  </body>
</html>
