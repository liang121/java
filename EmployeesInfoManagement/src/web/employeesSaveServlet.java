package web;
import dao.employeesDao;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.DateUtil;
import util.DbUtil;
import util.JsonUtil;
import util.ResponseUtil;
import util.StringUtil;
import model.employees;
import model.pageBean;

public class employeesSaveServlet extends HttpServlet {
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
		String empNum = request.getParameter("empNum");
		String empName = request.getParameter("empName");
		String sex = request.getParameter("sex");
		String departmentId = request.getParameter("departmentId");
		String email = request.getParameter("email");
		String empDesc = request.getParameter("employeesDesc");
		String employeesId = request.getParameter("employeesId");

		
		employees employees=null;
		try {
			employees = new employees (empNum, empName,sex, Integer.parseInt(departmentId), email,empDesc);
		}  catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtil.isNotEmpty(employeesId)){
			employees.setEmployeesId(Integer.parseInt(employeesId));
		}
		Connection con=null;
		try{
			con = dbUtil.getCon();
			int saveNums=0;
			JSONObject result = new JSONObject();
			if(StringUtil.isNotEmpty(employeesId)){
				saveNums = employeesDao.employeesUpdate(con,employees);
			}else{
				saveNums = employeesDao.employeesAdd(con, employees);
			}
			if(saveNums>0){
				result.put("success", "true");
			}else{
				result.put("success", "true");
				result.put("errorMsg", "delete failure");
			}
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
