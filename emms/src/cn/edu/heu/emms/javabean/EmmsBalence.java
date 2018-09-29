package cn.edu.heu.emms.javabean;

import java.sql.Date;
import java.sql.Timestamp;

public class EmmsBalence {
	
	private int  userno; 

	private String addr;
	private String com;
	private String contact;
	private String group;
	private String id;
	private String name;
	private String phone;
	private String tel;
	private int repno;
	private Timestamp etime;
	private float price ; 
	private String status;
	private Timestamp stime;
	private int eqtno;
	private String type;
	private String brand;
	private String model;
	private String seriesnumber;
	private int recordno;
	private Timestamp time;
	private Timestamp reptime;
	private float salary;
	private String person;
	private int engno;
	private float materialprice;
	private int cptno;
	private int sum;
	private int dbno;
	private float cprice;
	private String promise;
	private String attention;
	public EmmsBalence(int userno, String addr, String com, String contact,
			String group, String id, String name, String phone, String tel,
			int repno, Timestamp etime, float price, String status,
			Timestamp stime, int eqtno, String type, String brand,
			String model, String seriesnumber, int recordno, Timestamp time,
			Timestamp reptime, float salary, String person, int engno,
			float materialprice, int cptno, int sum, int dbno, float cprice,
			String promise, String attention) {
		super();
		this.userno = userno;
		this.addr = addr;
		this.com = com;
		this.contact = contact;
		this.group = group;
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.tel = tel;
		this.repno = repno;
		this.etime = etime;
		this.price = price;
		this.status = status;
		this.stime = stime;
		this.eqtno = eqtno;
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.seriesnumber = seriesnumber;
		this.recordno = recordno;
		this.time = time;
		this.reptime = reptime;
		this.salary = salary;
		this.person = person;
		this.engno = engno;
		this.materialprice = materialprice;
		this.cptno = cptno;
		this.sum = sum;
		this.dbno = dbno;
		this.cprice = cprice;
		this.promise = promise;
		this.attention = attention;
	}
	public EmmsBalence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getRepno() {
		return repno;
	}
	public void setRepno(int repno) {
		this.repno = repno;
	}
	public Timestamp getEtime() {
		return etime;
	}
	public void setEtime(Timestamp etime) {
		this.etime = etime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getStime() {
		return stime;
	}
	public void setStime(Timestamp stime) {
		this.stime = stime;
	}
	public int getEqtno() {
		return eqtno;
	}
	public void setEqtno(int eqtno) {
		this.eqtno = eqtno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSeriesnumber() {
		return seriesnumber;
	}
	public void setSeriesnumber(String seriesnumber) {
		this.seriesnumber = seriesnumber;
	}
	public int getRecordno() {
		return recordno;
	}
	public void setRecordno(int recordno) {
		this.recordno = recordno;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Timestamp getReptime() {
		return reptime;
	}
	public void setReptime(Timestamp reptime) {
		this.reptime = reptime;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public int getEngno() {
		return engno;
	}
	public void setEngno(int engno) {
		this.engno = engno;
	}
	public float getMaterialprice() {
		return materialprice;
	}
	public void setMaterialprice(float materialprice) {
		this.materialprice = materialprice;
	}
	public int getCptno() {
		return cptno;
	}
	public void setCptno(int cptno) {
		this.cptno = cptno;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getDbno() {
		return dbno;
	}
	public void setDbno(int dbno) {
		this.dbno = dbno;
	}
	public float getCprice() {
		return cprice;
	}
	public void setCprice(float cprice) {
		this.cprice = cprice;
	}
	public String getPromise() {
		return promise;
	}
	public void setPromise(String promise) {
		this.promise = promise;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	
	
	
}