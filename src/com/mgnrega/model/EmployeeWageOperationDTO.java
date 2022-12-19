package com.mgnrega.model;

import java.sql.Date;

public class EmployeeWageOperationDTO {
	
	private int eid;
	private String name;
	private int projectID;
	private String ProjectName;
	private Date date_joined;
	private int noOfDays;
	private int wage;
	private int totalAmount;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public Date getDate_joined() {
		return date_joined;
	}
	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public EmployeeWageOperationDTO(int eid, String name, int projectID, String projectName, Date date_joined,int noOfDays, int wage, int totalAmount) {
		super();
		this.eid = eid;
		this.name = name;
		this.projectID = projectID;
		this.ProjectName = projectName;
		this.date_joined = date_joined;
		this.noOfDays = noOfDays;
		this.wage = wage;
		this.totalAmount = totalAmount;
	}
	public EmployeeWageOperationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeWageOperationDTO [eid=" + eid + ", name=" + name + ", projectID=" + projectID + ", ProjectName="
				+ ProjectName + ", date_joined=" + date_joined + ", noOfDays=" + noOfDays + ", wage=" + wage
				+ ", totalAmount=" + totalAmount + "]";
	}
	
	
	

}
