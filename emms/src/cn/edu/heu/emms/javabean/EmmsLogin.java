package cn.edu.heu.emms.javabean;

public class EmmsLogin {
	//
	private String loginer;
	private String password;
	
	public EmmsLogin(){
		super();
	}

	public String getLoginer() {
		return loginer;
	}

	public void setLoginer(String loginer) {
		this.loginer = loginer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public EmmsLogin( String loginer, String password){
		this.loginer = loginer;
		this.password = password;
	}
	
}
