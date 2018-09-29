package cn.edu.heu.emms.javabean;

public class EmmsDb {
	private int no;
	private String cname;
	private String cmodel;
	private float cprice;
	private int csum;
	private int wsum;
	private String status;
	public EmmsDb(int no, String cname, String cmodel, float cprice, int csum,
			int wsum, String status) {
		super();
		this.no = no;
		this.cname = cname;
		this.cmodel = cmodel;
		this.cprice = cprice;
		this.csum = csum;
		this.wsum = wsum;
		this.status = status;
	}
	public EmmsDb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCmodel() {
		return cmodel;
	}
	public void setCmodel(String cmodel) {
		this.cmodel = cmodel;
	}
	public float getCprice() {
		return cprice;
	}
	public void setCprice(float cprice) {
		this.cprice = cprice;
	}
	public int getCsum() {
		return csum;
	}
	public void setCsum(int csum) {
		this.csum = csum;
	}
	public int getWsum() {
		return wsum;
	}
	public void setWsum(int wsum) {
		this.wsum = wsum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
