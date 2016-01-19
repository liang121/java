<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Information</title>
<link rel="stylesheet" type="text/css" href="assets/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="assets/jquery-easyui/themes/icon.css">
<script type="text/javascript" src="assets/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="assets/jquery-easyui/jquery.easyui.min.js"></script>
<link href="http://fonts.googleapis.com/css?family=Crimson+Text" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Allerta" rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<script>
	var url;
	function searchDepartment(){
		$('#t_d').datagrid('load',{
			departmentName: $('#s_departmentName').val()
		})
		
	}
	function departmentDelete(){
		var selectRows = $("#t_d").datagrid('getSelections');
		if(selectRows.length==0){
			$.messager.alert("Remind","You didn't select any items");
		}
		var strIds = [];
		for(var i=0;i<selectRows.length;i++){
			console.log(selectRows[i]);
			console.log(selectRows[i].departmentInfo);
			strIds.push(selectRows[i].id);
		}
		var ids = strIds.join(",");
		$.messager.confirm("Remind","Are you sure of deleting the "+selectRows.length+" items?",function(r){
			if(r){
				$.post("departmentDelete",{delIds:ids},function(result){
					if(result.success){
					$.messager.alert("system remind","you have successfuly delete "+result.delNums+" items");
						$("#t_d").datagrid("reload");
					}else{
						alert("delete failure");
					}
				},"json")
			}
		})

	}
	function openAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","add department information");
		url = "departmentSave";
	}
	function closeDepartmentDlg(){
		$("#dlg").dialog("close");
		resetValue();
	}
	function resetValue(){
		$("#departmentName").val("");
		$("#departmentDesc").val("");
	}       
	function saveDepartment(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				if(result.errorMsg){
					$.messager.alert("system reminder",result.errorMsg);
				}else{
					$.messager.alert("system reminder", "save successfully");
					resetValue();
					$("#dlg").dialog("close");
					$("#t_d").datagrid("reload");
				}
			}
		})
	}
	function openUpdateDialog(){
		var selectRows = $("#t_d").datagrid('getSelections');
		if(selectRows.length!=1){
			$.messager.alert("Remind","Please select only one item");
			return;
		}
		var row = selectRows[0];
		$("#dlg").dialog("open").dialog("setTitle","edit department information");
		console.log(row);
		$("#departmentName").val(row.departmentInfo);
		$("#departmentDesc").val(row.departmentDesc);
		url = "departmentSave?id=" + row.id;
	}
</script>
<style>
	iframe{
		height:400px;
	}
</style>
</head>
<body>
	<table id="t_d" title="department information management" class="easyui-datagrid" fitColumns="true" 
	pagination="true" rownumbers="true"  url="departmentList" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="id" width="50">id</th>
				<th field="departmentInfo" width="100">department name</th>
				<th field="departmentDesc" width="200">department description</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<div>
			<a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">add</a>
			<a href="javascript:openUpdateDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">edit</a>
			<a href="javascript:departmentDelete()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">delete</a>
		</div>
		<div>department name: <input type="text" name="s_departmentName" id="s_departmentName" style="margin-left:10px">
			<a href="javascript:searchDepartment()" class="easyui-linkbutton" iconCls="icon-search" plain="true"> search</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
	<form id="fm" method="post">
		<table>
			<tr>
				<td>department name</td>
				<td><input type="text" name="departmentName" id="departmentName"></td>
			</tr>
			<tr>
				<td>department description</td>
				<td><textarea rows="7" cols="30" name="departmentDesc" id="departmentDesc"></textarea></td>
			</tr>
		</table>
	</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveDepartment()" class="easyui-linkbutton" iconCls="icon-ok">save</a>
		<a href="javascript:closeDepartmentDlg()" class="easyui-linkbutton" iconCls="icon-cancel">cancel</a>
	</div>
	
</body>
</html>