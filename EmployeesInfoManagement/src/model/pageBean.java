package model;

public class pageBean {
	private int page;
	private int rows;
	private int start;
	
	public pageBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart() {
		return (page-1)*rows;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
}
