package web;
import dao.employeesDao;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.DbUtil;
import util.JsonUtil;
import util.ResponseUtil;
import util.StringUtil;
import model.employees;
import model.pageBean;

public class employeesListServlet extends HttpServlet {
	DbUtil dbUtil = new DbUtil();
	employeesDao employeesDao = new employeesDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String empNum = request.getParameter("empNum");
		String empName = request.getParameter("empName");
		String sex = request.getParameter("sex");
		String departmentId = request.getParameter("departmentId");
		employees employees = new employees();
		if(empNum != null){
			employees.setEmpNum(empNum);
			employees.setEmpName(empName);
			employees.setSex(sex);
			if(StringUtil.isNotEmpty(departmentId)){
				employees.setDepartmentId(Integer.parseInt(departmentId));
			}
		}
		pageBean pageBean = new pageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(employeesDao.employeesList(con, pageBean,employees));
			int total = employeesDao.employeesCount(con,employees);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
