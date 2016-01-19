package dao;

import java.sql.PreparedStatement;

import model.pageBean;

import java.sql.Connection;
import java.sql.ResultSet;
import model.departmentList;
import util.StringUtil;

public class departmentDao {
	public ResultSet departmentList(Connection con,pageBean pageBean, departmentList department) throws Exception{
		StringBuffer sb=new StringBuffer("select * from table_department");
		if(department!=null&&StringUtil.isNotEmpty(department.getDepartmentInfo())){
			sb.append(" and departmentInfo like '%" + department.getDepartmentInfo() + "%'");
		}
		if(pageBean !=null){
			sb.append(" limit " + pageBean.getStart() + ","+pageBean.getRows());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return  pstmt.executeQuery();
	}
	public int departmentCount(Connection con, departmentList department)throws Exception{
		StringBuffer sb = new StringBuffer( "select count(*) as total from table_department");
		if(StringUtil.isNotEmpty(department.getDepartmentInfo())){
			sb.append(" and departmentInfo like '%" + department.getDepartmentInfo() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	public int departmentDelete(Connection con, String delIds) throws Exception{
		String sql = "delete from table_department where id in ("+delIds+")";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	public int departmentAdd(Connection con, departmentList department) throws Exception{
		String sql = "insert into table_department values (null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, department.getDepartmentInfo());
		pstmt.setString(2, department.getDepartmentDesc());
		return pstmt.executeUpdate();
	}
	public int departmentEdit(Connection con, departmentList department) throws Exception{
		String sql = "update table_department set departmentInfo=?,departmentDesc=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, department.getDepartmentInfo());
		pstmt.setString(2, department.getDepartmentDesc());
		pstmt.setInt(3, department.getId());
		return pstmt.executeUpdate();
	}
}
