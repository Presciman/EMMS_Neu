package cn.edu.heu.emms.javabean;

public class EmmsUser {
	
	private int    no; 
	private String name;
	private String id;
	private String group;
	private String com;
	private String tel;
	private String phone;
	private String addr;
	private String post;
	private String contact;
	private String email;
	
	public EmmsUser (int no,String name, String id, String group, String com, String tel, String  phone, String addr, String post, String contact, String email)
	{
		super();
		
		this.no = no;
		this.name = name;
		this.id = id;
		this.group = group;
		this.com = com;
		this.tel = tel;
		this.phone = phone;
		this.addr = addr;
		this.post = post;
		this.contact = contact;	
		this.email = email;
	}

	
	
	public EmmsUser() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	
}
