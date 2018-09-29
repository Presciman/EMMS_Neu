package cn.edu.heu.emms.javabean;

public class EmmsCpt {
	
	private String name;
	private String model;
	private int sum;
	private int recordno;
	private int db;
	public EmmsCpt(String name, String model, int sum, int recordno, int db) {
		super();
		this.name = name;
		this.model = model;
		this.sum = sum;
		this.recordno = recordno;
		this.db = db;
	}
	public EmmsCpt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getRecordno() {
		return recordno;
	}
	public void setRecordno(int recordno) {
		this.recordno = recordno;
	}
	public int getDb() {
		return db;
	}
	public void setDb(int db) {
		this.db = db;
	}
	

}
