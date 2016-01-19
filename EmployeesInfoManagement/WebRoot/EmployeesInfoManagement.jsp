<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information</title>
<link rel="stylesheet" type="text/css" href="assets/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="assets/jquery-easyui/themes/icon.css">
<script type="text/javascript" src="assets/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="assets/jquery-easyui/jquery.easyui.min.js"></script>
<link href="http://fonts.googleapis.com/css?family=Crimson+Text" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Allerta" rel="stylesheet" type="text/css">
<script type="text/javascript">
	var url;
	
	function searchEmployees(){
		$('#t_d').datagrid('load',{
			empNum: $('#s_empNum').val(),
			empName: $('#s_empName').val(),
			sex: $('#s_sex').combobox("getValue"),
			departmentId: $('#s_departmentId').combobox("getValue"),
		})	
	}
	function saveEmployees(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				if($('#sex').combobox("getValue")==""){
					$.messager.alert("system reminder","choose sex field");
					return false;
				}
				if($('#departmentId').combobox("getValue")==""){
					$.messager.alert("system reminder","choose department field");
					return false;
				}
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
	function employeesDelete(){
		var selectRows = $("#t_d").datagrid('getSelections');
		if(selectRows.length==0){
			$.messager.alert("Remind","You didn't select any items");
		}
		var strIds = [];
		for(var i=0;i<selectRows.length;i++){
			console.log(selectRows[i]);
			console.log(selectRows[i].employeesInfo);
			strIds.push(selectRows[i].employeesId);
		}
		var ids = strIds.join(",");
		$.messager.confirm("Remind","Are you sure of deleting the "+selectRows.length+" items?",function(r){
			if(r){
				$.post("employeesDelete",{delIds:ids},function(result){
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
	function openUpdateDialog(){
		var selectRows = $("#t_d").datagrid('getSelections');
		if(selectRows.length!=1){
			$.messager.alert("Remind","Please select only one item");
			return;
		}
		var row = selectRows[0];
		$("#dlg").dialog("open").dialog("setTitle","edit employees information");
		$("#fm").form("load",row);
		/* $("#empName").val(row.empName);
		$("#employeesDesc").val(row.employeesDesc); */
		url = "employeesSave?employeesId=" + row.employeesId;
	}
	function resetValue(){
		$("#empNum").val("");
		$("#empName").val("");
		$("#sex").combobox("setValue","");
		$("#email").val("");
		$("#departmentId").combobox("setValue","");
		$("#employeesDesc").val("");
	}
	
	function openAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","add employees information");
		url = "employeesSave";
	}
	function closeEmployeesDlg(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
</script>
</head>
<body style="margin:0px" >
	<table id="t_d" title="employees information management" class="easyui-datagrid" fitColumns="true" 
	pagination="true" rownumbers="true"  url="employeesList" toolbar="#tb" striped="true">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="employeesId" width="50" align="center">id</th>
				<th field="empNum" width="100" align="center">emp num</th>
				<th field="empName" width="200" align="center">emp name</th>
				<th field="sex" width="200" align="center">sex</th>
				<!-- <th field="birthday" width="200" align="center">birthday</th> -->
				<th field="departmentId" width="200" align="center">department id</th>
				<th field="email" width="200" align="center">email</th>
				<th field="employeesDesc" width="200" align="center">emp description</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<div>
			<a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">add</a>
			<a href="javascript:openUpdateDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">edit</a>
			<a href="javascript:employeesDelete()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">delete</a>
		</div>
		<div><span>employees Num:</span> <input type="text" name="s_empNum" id="s_empNum" size="10">
			 <span style="margin-left:10px">Name:</span> <input type="text" name="s_empName" id="s_empName" size="10">
			 <span style="margin-left:10px;margin-right:10px">Sex</span>
			 <select class="easyui-combobox" id="s_sex" name="s_sex" editable="false" panelHeight="auto" >
			 	<option value="">choose...</option>
			 	<option value="male">male</option>
			 	<option value="female">female</option>
			 </select>
			  <!-- <span style="margin-left:10px;margin-right:10px">Birthday:</span><input class="easyui-datebox" name="s_sbirthday" id="s_sbirthday" size="10"> to 
			  																	<input class="easyui-datebox" name="s_ebirthday" id="s_ebirthday" size="10"> -->
			   <span style="margin-left:10px;margin-right:10px">Department:</span><input class="easyui-combobox" name="s_departmentId" id="s_departmentId" size="10" data-options="editable:false,valueField:'id',textField:'departmentInfo',url:'departmentComboList'">
			<a href="javascript:searchEmployees()" class="easyui-linkbutton" iconCls="icon-search" plain="true"> search</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 600px;height:350px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px">
				<tr>
					<td>emp num</td>
					<td><input type="text" name="empNum" id="empNum" class="easyui-validatebox" required="true"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>mep name</td>
					<td><input type="text" name="empName" id="empName" class="easyui-validatebox" required="true"></td>
				</tr>
				<tr>
					<td>sex</td>
					<td>
						<select class="easyui-combobox" id="sex" name="sex" editable="false" panelHeight="auto" class="easyui-validatebox" required="true">
						 	<option value="">choose...</option>
						 	<option value="male">male</option>
						 	<option value="female">female</option>
						 </select>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<!-- <td>birthday</td>
					<td><input class="easyui-datebox" name="birthday" id="birthday"  class="easyui-validatebox" required="true"></td> -->
				</tr>
				<tr>
					<td>department id</td>
					<td><input class="easyui-combobox" name="departmentId" id="departmentId"  data-options="editable:false,valueField:'id',textField:'departmentInfo',url:'departmentComboList'" required="true"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>email</td>
					<td><input type="text" name="email" id="email" class="easyui-validatebox" required="true" validType="email"></td>
				</tr>
				<tr>
					<td>emp description</td>
					<td colspan="4"><textarea rows="7" cols="50" name="employeesDesc" id="employeesDesc"  required="true"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveEmployees()" class="easyui-linkbutton" iconCls="icon-ok">save</a>
		<a href="javascript:closeEmployeesDlg()" class="easyui-linkbutton" iconCls="icon-cancel">cancel</a>
	</div>
</body>
</html>