package com.mgnrega.model;

public class Project {
	
	private int pid;
	private int pgpid;
	private String pname;
	private int pcost;
	private int duration;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPgpid() {
		return pgpid;
	}
	public void setPgpid(int pgpid) {
		this.pgpid = pgpid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Project(int pid, int pgpid, String pname, int pcost, int duration) {
		super();
		this.pid = pid;
		this.pgpid = pgpid;
		this.pname = pname;
		this.pcost = pcost;
		this.duration = duration;
	}
	
	public Project() {
		super();
		
	}
	
	
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pgpid=" + pgpid + ", pname=" + pname + ", pcost=" + pcost + ", duration="
				+ duration + "]";
	}
	
	
	
	

}
