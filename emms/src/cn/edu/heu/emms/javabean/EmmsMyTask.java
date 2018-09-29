package cn.edu.heu.emms.javabean;

import java.util.Date;

public class EmmsMyTask {
	       private int repno;
           private int recordno;
           private Date stime;
           private Date etime;
           private String type;
           private Date recordtime;
           private String recordstatus;
           private int engno;
           private int eqtno;
		public EmmsMyTask() {
			super();
			// TODO Auto-generated constructor stub
		}
		public EmmsMyTask(int repno, int recordno, Date stime, Date etime,
				String type, Date recordtime, String recordstatus, int engno,
				int eqtno) {
			super();
			this.repno = repno;
			this.recordno = recordno;
			this.stime = stime;
			this.etime = etime;
			this.type = type;
			this.recordtime = recordtime;
			this.recordstatus = recordstatus;
			this.engno = engno;
			this.eqtno = eqtno;
		}
		public int getRepno() {
			return repno;
		}
		public void setRepno(int repno) {
			this.repno = repno;
		}
		public int getRecordno() {
			return recordno;
		}
		public void setRecordno(int recordno) {
			this.recordno = recordno;
		}
		public Date getStime() {
			return stime;
		}
		public void setStime(Date stime) {
			this.stime = stime;
		}
		public Date getEtime() {
			return etime;
		}
		public void setEtime(Date etime) {
			this.etime = etime;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Date getRecordtime() {
			return recordtime;
		}
		public void setRecordtime(Date recordtime) {
			this.recordtime = recordtime;
		}
		public String getRecordstatus() {
			return recordstatus;
		}
		public void setRecordstatus(String recordstatus) {
			this.recordstatus = recordstatus;
		}
		public int getEngno() {
			return engno;
		}
		public void setEngno(int engno) {
			this.engno = engno;
		}
		public int getEqtno() {
			return eqtno;
		}
		public void setEqtno(int eqtno) {
			this.eqtno = eqtno;
		}
		
		
           
		
		
		
           
}
