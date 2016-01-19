package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




import org.apache.commons.httpclient.util.DateUtil;

import model.employees;
import model.pageBean;
import util.StringUtil;

public class employeesDao {
	public ResultSet employeesList(Connection con,pageBean pageBean,employees employees ) throws Exception{
		StringBuffer sb=new StringBuffer("select * from table_employees e, table_department d where e.departmentId=d.id");
		if(StringUtil.isNotEmpty(employees.getEmpNum())){
			sb.append(" and e.empNum like '%"+employees.getEmpNum()+"%'");
		}
		if(StringUtil.isNotEmpty(employees.getEmpName())){
			sb.append(" and e.empName like '%"+employees.getEmpName()+"%'");
		}
		if(StringUtil.isNotEmpty(employees.getSex())){
			sb.append(" and e.sex = '"+employees.getSex()+"'");
		}
		if(employees.getDepartmentId()!=-1){
			sb.append(" and e.departmentId = '"+employees.getDepartmentId()+"'");
		}
//		if(StringUtil.isNotEmpty(sbirthday)){
//			sb.append(" and TO_DAYS(e.birthday)>=TO_DAYS('"+sbirthday+"')");
//		}
//		if(StringUtil.isNotEmpty(ebirthday)){
//			sb.append(" and TO_DAYS(e.birthday)<=TO_DAYS('"+ebirthday+"')");
//		}
		if(pageBean !=null){
			sb.append(" limit " + pageBean.getStart() + ","+pageBean.getRows());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return  pstmt.executeQuery();
	}
	public int employeesCount(Connection con,employees employees)throws Exception{
		StringBuffer sb = new StringBuffer( "select count(*) as total from table_employees e,table_department d where e.departmentId=d.id");
		if(StringUtil.isNotEmpty(employees.getEmpNum())){
			sb.append(" and e.empNum like '%"+employees.getEmpNum()+"%'");
		}
		if(StringUtil.isNotEmpty(employees.getEmpName())){
			sb.append(" and e.empName like '%"+employees.getEmpName()+"%'");
		}
		if(StringUtil.isNotEmpty(employees.getSex())){
			sb.append(" and e.sex = '"+employees.getSex()+"'");
		}
		if(employees.getDepartmentId()!=-1){
			sb.append(" and e.departmentId = '"+employees.getDepartmentId()+"'");
		}
//		if(StringUtil.isNotEmpty(sbirthday)){
//			sb.append(" and TO_DAYS(e.birthday)>=TO_DAYS('"+sbirthday+"')");
//		}
//		if(StringUtil.isNotEmpty(ebirthday)){
//			sb.append(" and TO_DAYS(e.birthday)<=TO_DAYS('"+ebirthday+"')");
//		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	public int employeesDelete(Connection con, String delIds) throws Exception{
		String sql = "delete from table_employees where employeesId in ("+delIds+")";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int employeesAdd(Connection con, employees employees) throws Exception{
		String sql = "insert into table_employees values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, employees.getEmpNum());
		pstmt.setString(2, employees.getEmpName());
		pstmt.setString(3, employees.getSex());
		pstmt.setInt(4, employees.getDepartmentId());
		pstmt.setString(5, employees.getEmail());
		pstmt.setString(6, employees.getEmployeesDesc());
		return pstmt.executeUpdate();
	}
	public int employeesUpdate(Connection con, employees employees) throws Exception{
		String sql = "update table_employees set empNum=?,EmpName=?,sex=?,departmentId=?,email=?,employeesDesc=? where employeesId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, employees.getEmpNum());
		pstmt.setString(2, employees.getEmpName());
		pstmt.setString(3, employees.getSex());
		pstmt.setInt(4, employees.getDepartmentId());
		pstmt.setString(5, employees.getEmail());
		pstmt.setString(6, employees.getEmployeesDesc());
		pstmt.setInt(7, employees.getEmployeesId());
		return pstmt.executeUpdate();
	}

}
