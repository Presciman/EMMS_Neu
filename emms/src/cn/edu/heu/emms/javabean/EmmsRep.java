package cn.edu.heu.emms.javabean;

import java.util.Date;

public class EmmsRep {
	
	private int no;
	
	private Date stime;
	private Float price;
	private Date etime;
	private String status;
	private int userno;
	private int eqtno;
	
	

	public EmmsRep(int no, Date stime, Float price, Date etime, String status,
			int userno, int eqtno) {
		super();
		this.no = no;
		this.stime = stime;
		this.price = price;
		this.etime = etime;
		this.status = status;
		this.userno = userno;
		this.eqtno = eqtno;
	}

	public EmmsRep() {
		super();
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getEqtno() {
		return eqtno;
	}

	public void setEqtno(int eqtno) {
		this.eqtno = eqtno;
	}
	
	
}