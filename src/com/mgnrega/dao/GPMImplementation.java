package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.exception.CredentialException;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.GramPanchayatException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.EmployeeWageOperationDTO;
import com.mgnrega.model.Project;
import com.mgnrega.utility.DBUtility;

public class GPMImplementation implements GPMInterface{
	
	public static int storedGpmID;
	


	@Override
	public String gmpLogin(String phone, String password) throws CredentialException, GramPanchayatException {
		String result = "Log In failed";
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from grampanchayat");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String phoneNumber = rs.getString("gphone");
				String pass = rs.getString("gpassword");
				
				if(phoneNumber.equals(phone) && pass.equals(password)) {
					result = "login Sucessful!";
					storedGpmID = rs.getInt("GPID");
					return result;
				}
					
					
			}
			result = "Wrong Credential";
			throw new CredentialException(result);
			
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}		
		
		
	}

	/**********************************************************************************************************************************************************/
	
	
	
	
	@Override
	public String createEmployee(Employee e) throws EmployeeException {
		
		String result ="Employee Not Created.";
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee(egpid,ename,eaddress,edate_joined,ewage) values(?,?,?,curdate(),?)");
			ps.setInt(1, e.getEgpid());
			ps.setString(2, e.getEname());
			ps.setString(3, e.getEaddress());
			ps.setInt(4, e.getEwage());
			
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Employee Created.";
			}else {
				throw new EmployeeException(result);
			}
			
		} catch (SQLException s) {
			throw new EmployeeException(s.getMessage());
		}
		
		return result;
	}


	/**********************************************************************************************************************************************************/



	@Override
	public List<Employee> displayAllEmployee() throws EmployeeException {
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				int egpid = rs.getInt("egpid");
				int epid = rs.getInt("epid");
				String name = rs.getString("ename");
				String address = rs.getString("eaddress");
				Date date = rs.getDate("edate_joined");
				int wage = rs.getInt("ewage");
				
				
				Employee e = new Employee(eid, egpid, epid, name, address, date, wage);
				empList.add(e);
			}
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(empList.size() ==0) {
			throw new EmployeeException("Exception : No Employeet Found.");
		}
		
		return empList;
	}


	/**********************************************************************************************************************************************************/



	@Override
	public String assignEmployeeToProject(int pid, int eid)throws EmployeeException, ProjectException, GramPanchayatException {
		String result = "Employee not assinged to project";
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid = ? and egpid =?");
			ps.setInt(1, eid);
			ps.setInt(2, storedGpmID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from project where pid = ? and pgpid =?");
				ps2.setInt(1, pid);
				ps2.setInt(2, storedGpmID);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()){
					
					PreparedStatement ps3 = conn.prepareStatement("update employee set epid = ? where eid =?");
					ps3.setInt(1, pid);
					ps3.setInt(2, eid);
					
					int x = ps3.executeUpdate();
					
					if(x>0) {
						result = "Project with PID ID : " + pid + " assigned to employee with EID ID : " + eid;
						return result;
					}
					
					
					
				}else {
					throw new ProjectException("Either Project don't exist or NOT assinged to Logined Gram Panchayat Member Account by BDO");
				}
				
				
			}else {
				throw new EmployeeException("Either employee don't exist or assigned by different Gram Panchayat Member ");
			}
			
			
			
			
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}
	
		return result;
	}


	/**********************************************************************************************************************************************************/



	@Override
	public List<EmployeeWageOperationDTO> employeedaysAndWage() throws EmployeeException {
		List<EmployeeWageOperationDTO> dayandWageList = new ArrayList<>();
		
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(" select e.eid,e.ename,p.pid,p.pname,e.edate_joined,datediff(curdate(),edate_joined) days,e.ewage,datediff(curdate(),edate_joined)*e.ewage total from employee e inner join project p on e.epid = p.pid group by e.eid");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				Date date = rs.getDate("edate_joined");
				int days = rs.getInt("days");
				int wage = rs.getInt("ewage");
				int total = rs.getInt("total");
				
				EmployeeWageOperationDTO empWageTotal = new EmployeeWageOperationDTO(eid, ename, pid, pname, date, days, wage, total);
				dayandWageList.add(empWageTotal);	
				
			}
			
			
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		if(dayandWageList.size() ==0) {
			throw new EmployeeException("Exception : No employee Found in DataBase");
		}
			
		return dayandWageList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	


