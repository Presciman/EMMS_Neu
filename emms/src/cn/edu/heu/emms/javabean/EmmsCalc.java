package cn.edu.heu.emms.javabean;

public class EmmsCalc {
	private int no;
	private float sum;
	private int recordno;
	public EmmsCalc(int no, float sum, int recordno) {
		super();
		this.no = no;
		this.sum = sum;
		this.recordno = recordno;
	}
	public EmmsCalc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public int getRecordno() {
		return recordno;
	}
	public void setRecordno(int recordno) {
		this.recordno = recordno;
	}

}
