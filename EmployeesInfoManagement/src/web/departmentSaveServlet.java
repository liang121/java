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
import util.StringUtil;
import model.departmentList;
import model.pageBean;

public class departmentSaveServlet extends HttpServlet {
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
		String departmentName = request.getParameter("departmentName");
		String departmentDesc = request.getParameter("departmentDesc");
		String id= request.getParameter("id");
		departmentList department = new departmentList(departmentName,departmentDesc);
		if(StringUtil.isNotEmpty(id)){
			department.setId(Integer.parseInt(id));
		}
		Connection con=null;
		try{
			con = dbUtil.getCon();
			int saveNums=0;
			JSONObject result = new JSONObject();
			if(StringUtil.isNotEmpty(id)){
				saveNums = departmentDao.departmentEdit(con,department);
			}else{
				saveNums = departmentDao.departmentAdd(con, department);
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
