package cn.edu.heu.emms.javabean;

import java.util.Date;

public class EmmsTasking {
           
			private int repno;
			private int recordno;
            private Date stime;
            private Date etime;
            private Date recordtime;
            private String type;
            private String repstatus;
            private String recordstatus;
            private int eqtno;
			public EmmsTasking() {
				super();
				// TODO Auto-generated constructor stub
			}
			public EmmsTasking(int repno, int recordno, Date stime, Date etime,
					Date recordtime, String type, String repstatus,
					String recordstatus, int eqtno) {
				super();
				this.repno = repno;
				this.recordno = recordno;
				this.stime = stime;
				this.etime = etime;
				this.recordtime = recordtime;
				this.type = type;
				this.repstatus = repstatus;
				this.recordstatus = recordstatus;
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
			public Date getRecordtime() {
				return recordtime;
			}
			public void setRecordtime(Date recordtime) {
				this.recordtime = recordtime;
			}
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			public String getRepstatus() {
				return repstatus;
			}
			public void setRepstatus(String repstatus) {
				this.repstatus = repstatus;
			}
			public String getRecordstatus() {
				return recordstatus;
			}
			public void setRecordstatus(String recordstatus) {
				this.recordstatus = recordstatus;
			}
			public int getEqtno() {
				return eqtno;
			}
			public void setEqtno(int eqtno) {
				this.eqtno = eqtno;
			}
			
            
            
            
            
            
}
