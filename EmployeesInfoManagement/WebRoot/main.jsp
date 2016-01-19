<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
<%
	 if(session.getAttribute("currentUser")==null){
		response.sendRedirect("index.jsp");
		return;
	} 
 %>
	<link rel="stylesheet" type="text/css" href="assets/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="assets/jquery-easyui/themes/icon.css">
	<script type="text/javascript" src="assets/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="assets/jquery-easyui/jquery.easyui.min.js"></script>
	<link href="http://fonts.googleapis.com/css?family=Crimson+Text" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=Allerta" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script>
			
			$(function(){
				var treeData = [{
				text: "root",
				children:[{
					text:"Departments",
					attributes:{
						url:"departmentInfoManagement.jsp",}
					},{
						text:"Employees",
						attributes:{
							url:"EmployeesInfoManagement.jsp",
						}
					}],
				}];
				$("#tree").tree({
					data:treeData,
					lines:true,
					onClick:function(node){
						if(node.attributes){
							addTabs(node.text,node.attributes.url);
						}
					}
				});
				function addTabs(text,url){
					if($("#tabs").tabs("exists",text)){
						$("#tabs").tabs("select",text);
					}else{
						$("#tabs").tabs("add",{
						title:text,
						content:"<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>",
						closable:true
					});
					}
					
				}
				
			});
		</script>

</head>
<body style="margin:0px" class="easyui-layout">
	

		<div data-options="region:'north'" style="height:100px;background-image:url('assets/image/header-bg-img.jpg')">
			<span style="font-family: 'Crimson Text',Georgia, Times, serif; font-size: 40px;padding-left:20px">
				Employees Information DashBoard
			</span>
			<span style="font-size:15px;position:absolute;bottom:0px;right:10px">
				Current User: <span style="color:red;padding-left:10px">${currentUser.userName}</span>
			</span>
		</div>
		<div data-options="region:'south'" style="height:55px;text-align:center">copyright by liang</div>
		<div data-options="region:'west',split:true" title="Nav Menu" style="width:20%;">
			<ul id="tree"></ul>
		</div>
		
		<div data-options="region:'center',title:'Main Content',iconCls:'icon-ok'">
			<div class="easyui-tabs" data-options="fit:true,border:false,plain:true" id="tabs">
				<div title="Front Page" style="padding:5px">
					<h1>Welcome to ....</h1>
				</div>
			</div>
		</div>
	
</body>
</html>