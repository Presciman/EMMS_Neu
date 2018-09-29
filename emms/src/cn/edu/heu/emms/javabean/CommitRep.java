package cn.edu.heu.emms.javabean;

import java.util.Date;

public class CommitRep {

	int user_no;
	
	String user_com;
	String user_contact;
	String user_name;
	String user_addr;
    String user_phone;
    Date rep_stime;
    String rep_status;
    Date rep_etime;
    float rep_price;
    int eqt_no;
    String eqt_type;
    String eqt_brand;
    String eqt_model;
    String eqt_seriesnumber;
    String eqt_component;
    
    public CommitRep(int user_no, String user_com, String user_contact,
			String user_name, String user_addr, String user_phone,
			Date rep_stime, String rep_status, Date rep_etime,
			float rep_price, int eqt_no, String eqt_type, String eqt_brand,
			String eqt_model, String eqt_seriesnumber, String eqt_component) {
		super();
		this.user_no = user_no;
		this.user_com = user_com;
		this.user_contact = user_contact;
		this.user_name = user_name;
		this.user_addr = user_addr;
		this.user_phone = user_phone;
		this.rep_stime = rep_stime;
		this.rep_status = rep_status;
		this.rep_etime = rep_etime;
		this.rep_price = rep_price;
		this.eqt_no = eqt_no;
		this.eqt_type = eqt_type;
		this.eqt_brand = eqt_brand;
		this.eqt_model = eqt_model;
		this.eqt_seriesnumber = eqt_seriesnumber;
		this.eqt_component = eqt_component;
	}

	public CommitRep() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_com() {
		return user_com;
	}

	public void setUser_com(String user_com) {
		this.user_com = user_com;
	}

	public String getUser_contact() {
		return user_contact;
	}

	public void setUser_contact(String user_contact) {
		this.user_contact = user_contact;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public Date getRep_stime() {
		return rep_stime;
	}

	public void setRep_stime(Date rep_stime) {
		this.rep_stime = rep_stime;
	}

	public String getRep_status() {
		return rep_status;
	}

	public void setRep_status(String rep_status) {
		this.rep_status = rep_status;
	}

	public Date getRep_etime() {
		return rep_etime;
	}

	public void setRep_etime(Date rep_etime) {
		this.rep_etime = rep_etime;
	}

	public float getRep_price() {
		return rep_price;
	}

	public void setRep_price(float rep_price) {
		this.rep_price = rep_price;
	}

	public int getEqt_no() {
		return eqt_no;
	}

	public void setEqt_no(int eqt_no) {
		this.eqt_no = eqt_no;
	}

	public String getEqt_type() {
		return eqt_type;
	}

	public void setEqt_type(String eqt_type) {
		this.eqt_type = eqt_type;
	}

	public String getEqt_brand() {
		return eqt_brand;
	}

	public void setEqt_brand(String eqt_brand) {
		this.eqt_brand = eqt_brand;
	}

	public String getEqt_model() {
		return eqt_model;
	}

	public void setEqt_model(String eqt_model) {
		this.eqt_model = eqt_model;
	}

	public String getEqt_seriesnumber() {
		return eqt_seriesnumber;
	}

	public void setEqt_seriesnumber(String eqt_seriesnumber) {
		this.eqt_seriesnumber = eqt_seriesnumber;
	}

	public String getEqt_component() {
		return eqt_component;
	}

	public void setEqt_component(String eqt_component) {
		this.eqt_component = eqt_component;
	}
    
    
}
