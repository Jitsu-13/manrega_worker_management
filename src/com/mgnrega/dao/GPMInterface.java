package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.exception.CredentialException;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.GramPanchayatException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.EmployeeWageOperationDTO;
import com.mgnrega.model.Project;

public interface GPMInterface {
	
	public String gmpLogin(String phone, String password) throws CredentialException , GramPanchayatException;
	
	public String createEmployee(Employee e) throws EmployeeException;
	
	public List<Employee> displayAllEmployee() throws EmployeeException;
	
	public String assignEmployeeToProject(int pid, int eid) throws EmployeeException, ProjectException, GramPanchayatException;
	
	public List<EmployeeWageOperationDTO> employeedaysAndWage() throws EmployeeException;
	
	

}
