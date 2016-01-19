package model;

import java.util.Date;

public class employees {
	private int employeesId;
	private String empNum;
	private String empName;
	private String sex;
//	private Date birthday;
	private int departmentId=-1;
	private String email;
	private String employeesDesc;
	private String departmentName;
	public employees(){
		super();
	}
	public employees(String empNum, String empName, String sex,
			int departmentId, String email, String employeesDesc) {
		super();
		this.empNum = empNum;
		this.empName = empName;
		this.sex = sex;
//		this.birthday = birthday;
		this.departmentId = departmentId;
		this.email = email;
		this.employeesDesc = employeesDesc;
	}
	public int getEmployeesId() {
		return employeesId;
	}
	public void setEmployeesId(int employeesId) {
		this.employeesId = employeesId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
//	public Date getBirthday() {
//		return birthday;
//	}
//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getEmployeesDesc() {
		return employeesDesc;
	}
	public void setEmployeesDesc(String stuDesc) {
		this.employeesDesc = employeesDesc;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
