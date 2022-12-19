package com.mgnrega.model;

public class GramPanchayat {
	
	private int gpid;
	private String gname;
	private String address;
	private String gphone;
	private String password;
	
	
	public GramPanchayat() {
		super();
	}
	
	public GramPanchayat(int gpid, String gname, String address, String gphone, String password) {
		super();
		this.gpid = gpid;
		this.gname = gname;
		this.address = address;
		this.gphone = gphone;
		this.password = password;
	}
	
	
	public int getGpid() {
		return gpid;
	}
	public void setGpid(int gpid) {
		this.gpid = gpid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGphone() {
		return gphone;
	}
	public void setGphone(String gphone) {
		this.gphone = gphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "GramPanchayat [gpid=" + gpid + ", gname=" + gname + ", address=" + address + ", gphone=" + gphone
				+ ", password=" + password + "]";
	}
	
	
	
	
	
	

}
