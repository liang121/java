package web;
import dao.departmentDao;

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
import model.departmentList;
import model.pageBean;

public class departmentListServlet extends HttpServlet {
	DbUtil dbUtil = new DbUtil();
	departmentDao departmentDao = new departmentDao();
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
		String departmentName = request.getParameter("departmentName");
		if(departmentName==null){
			departmentName="";
		}
		departmentList department = new departmentList();
		department.setDepartmentInfo(departmentName);
		pageBean pageBean = new pageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(departmentDao.departmentList(con, pageBean,department));
			int total = departmentDao.departmentCount(con,department);
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
