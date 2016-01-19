package model;

public class departmentList {
	
	private int id;
	private String departmentInfo;
	private String departmentDesc;
	
	public departmentList(String departmentInfo, String departmentDesc) {
		super();
		this.departmentInfo = departmentInfo;
		this.departmentDesc = departmentDesc;
	}
	public departmentList() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentInfo() {
		return departmentInfo;
	}
	public void setDepartmentInfo(String departmentInfo) {
		this.departmentInfo = departmentInfo;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	
}
