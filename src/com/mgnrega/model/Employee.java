package com.mgnrega.model;

import java.sql.Date;

public class Employee {
	
	private int eid;
	private int egpid;
	private int epid;
	private String ename;
	private String eaddress;
	private Date edate;
	private int ewage;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getEgpid() {
		return egpid;
	}
	public void setEgpid(int egpid) {
		this.egpid = egpid;
	}
	public int getEpid() {
		return epid;
	}
	public void setEpid(int epid) {
		this.epid = epid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public int getEwage() {
		return ewage;
	}
	public void setEwage(int ewage) {
		this.ewage = ewage;
	}
	
	public Employee(int eid, int egpid, int epid, String ename, String eaddress, Date edate, int ewage) {
		super();
		this.eid = eid;
		this.egpid = egpid;
		this.epid = epid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.edate = edate;
		this.ewage = ewage;
	}
	
	public Employee() {
		super();
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", egpid=" + egpid + ", epid=" + epid + ", ename=" + ename + ", eaddress="
				+ eaddress + ", edate=" + edate + ", ewage=" + ewage + "]";
	}
	
	
	
	
	

}
