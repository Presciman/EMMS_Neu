package cn.edu.heu.emms.javabean;
import java.util.Date;

public class EmmsRecord {
	
	private int no = 0;
	private int engno = 0;
	private String person;
	private Date time = null;
	private String checkout;
	private String repairment;
	private Date reptime = null;
	private String work;
	private float salary = 0;
	private float materialprice = 0;
	private String promise;
	private String attention;
	private String status;
	private String delay;
	private int repno = 0 ;
	public EmmsRecord(int no, int engno, String person, Date time,
			String checkout, String repairment, Date reptime, String work,
			float salary, float materialprice, String promise,
			String attention, String status, String delay, int repno) {
		super();
		this.no = no;
		this.engno = engno;
		this.person = person;
		this.time = time;
		this.checkout = checkout;
		this.repairment = repairment;
		this.reptime = reptime;
		this.work = work;
		this.salary = salary;
		this.materialprice = materialprice;
		this.promise = promise;
		this.attention = attention;
		this.status = status;
		this.delay = delay;
		this.repno = repno;
	}
	public EmmsRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getEngno() {
		return engno;
	}
	public void setEngno(int engno) {
		this.engno = engno;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public String getRepairment() {
		return repairment;
	}
	public void setRepairment(String repairment) {
		this.repairment = repairment;
	}
	public Date getReptime() {
		return reptime;
	}
	public void setReptime(Date reptime) {
		this.reptime = reptime;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getMaterialprice() {
		return materialprice;
	}
	public void setMaterialprice(float materialprice) {
		this.materialprice = materialprice;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	public int getRepno() {
		return repno;
	}
	public void setRepno(int repno) {
		this.repno = repno;
	}
	

}
