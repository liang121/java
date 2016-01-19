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
import model.employees;
import model.pageBean;

public class employeesDeleteServlet extends HttpServlet {
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
		String delIds = request.getParameter("delIds");
		Connection con=null;
		try{
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			int delNums = employeesDao.employeesDelete(con,delIds);
			if(delNums>0){
				result.put("success", "true");
				result.put("delNums", delNums);
			}else{
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
