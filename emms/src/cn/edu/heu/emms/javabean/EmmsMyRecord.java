package cn.edu.heu.emms.javabean;

import java.util.Date;

public class EmmsMyRecord {
	
	    private int repno;
        private int recordno;
        private Date recordtime;
        private String type;
        private String brand;
        private String model;
        private String seriesnumber;
        private int engno;
		public EmmsMyRecord() {
			super();
			// TODO Auto-generated constructor stub
		}
		public EmmsMyRecord(int repno, int recordno, Date recordtime,
				String type, String brand, String model, String seriesnumber,
				int engno) {
			super();
			this.repno = repno;
			this.recordno = recordno;
			this.recordtime = recordtime;
			this.type = type;
			this.brand = brand;
			this.model = model;
			this.seriesnumber = seriesnumber;
			this.engno = engno;
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
		public int getEngno() {
			return engno;
		}
		public void setEngno(int engno) {
			this.engno = engno;
		}
        
        
}
