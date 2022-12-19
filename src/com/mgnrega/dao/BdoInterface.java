package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.exception.BdoException;
import com.mgnrega.exception.CredentialException;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.GramPanchayatException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.GramPanchayat;
import com.mgnrega.model.Project;

public interface BdoInterface {
	
	public final String username = "bdo";
	public final String password = "bdo";
	
	public String bdologin(String username, String password) throws CredentialException;
	
	public String createProject(Project p) throws ProjectException;
	
	public List<Project> displayAllProject() throws ProjectException;
	
	public String createGramPanchayatMember(GramPanchayat g) throws GramPanchayatException;
	
	public List<GramPanchayat> displayAllGramPayanchayatMember() throws GramPanchayatException;
	
	public String allocateProjectToGPM(int gpmid, int pid) throws ProjectException, GramPanchayatException, BdoException;
	
	public List<Employee> employeeOnAProject(int pid) throws ProjectException, EmployeeException, BdoException;
	
}
