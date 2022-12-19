package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.mgnrega.exception.BdoException;
import com.mgnrega.exception.CredentialException;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.GramPanchayatException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.GramPanchayat;
import com.mgnrega.model.Project;
import com.mgnrega.utility.DBUtility;

public class BdoImplementation implements BdoInterface {
	
	/*----------------------------Login into their account------------------------------------------------------*/

	@Override
	public String bdologin(String username, String password) throws CredentialException {
		
		String result = "Invalid Credentials!";
		
		if (username.equals(BdoInterface.username) && password.equals(BdoInterface.password)) {
			 result = "Welcome to BDO Account. Login Successful!";
		}else {
			throw new CredentialException(result);
		}
		return result;	
	}
	
	
	/*----------------------------------- Create a project --------------------------------------------------------*/
	
	@Override
	public String createProject(Project p) throws ProjectException {
		
		String result ="Project Not Created.";
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into project (pname,pcost,pduration) values(?,?,?)");
			
			ps.setString(1, p.getPname());
			ps.setInt(2, p.getPcost());
			ps.setInt(3, p.getDuration());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Project Created.";
			}else {
				throw new ProjectException(result);
			}
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		return result;
	}

	
	
	/*----------------------------------- View List Of Project --------------------------------------------------------*/

	@Override
	public List<Project> displayAllProject() throws ProjectException {
		
		List<Project> projectList = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from project");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int pid = rs.getInt("pid");
				int pgpid = rs.getInt("pgpid");
				String name = rs.getString("pname");
				int cost = rs.getInt("pcost");
				int duration = rs.getInt("pduration");
				
				Project p = new Project(pid, pgpid, name, cost, duration);
				projectList.add(p);
			}
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		if(projectList.size() ==0) {
			throw new ProjectException("Exception : No Project Found.");
		}
		
		return projectList;
	}
	
	
	/*----------------------------Create new Gram Panchayat Member(GPM) --------------------------------------------------*/

	@Override
	public String createGramPanchayatMember(GramPanchayat g) throws GramPanchayatException {
		String result ="Gram Panchayat Member Data Not Inserted.";
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into grampanchayat (gname,gaddress,gphone,gpassword) values(?,?,?,?)");
			
			ps.setString(1, g.getGname());
			ps.setString(2, g.getAddress());
			ps.setString(3, g.getGphone());
			ps.setString(4, g.getPassword());
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Gram Panchayat data Inserted.";
			}else {
				throw new GramPanchayatException(result);
			}
			
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}
		
		return result;
	}

	
	/*-------------------------------- View List Of Gram Panchayat Member(GPM) ------------------------------------------------*/

	@Override
	public List<GramPanchayat> displayAllGramPayanchayatMember() throws GramPanchayatException {
		List<GramPanchayat> GPMList = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from grampanchayat");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int gpid = rs.getInt("GPID");
				String name = rs.getString("gName");
				String address = rs.getString("gaddress");
				String phone = rs.getString("gphone");
				String password = rs.getString("gpassword");
				
				
				GramPanchayat g = new GramPanchayat(gpid, name, address, phone, password);
				GPMList.add(g);
			}
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}
		
		if(GPMList.size() ==0) {
			throw new GramPanchayatException("Exception : No Gram Panchayat Member Found.");
		}
		
		return GPMList;
		
		
	}


	/*------------------------------------ Allocate  Project to GPM --------------------------------------------------------*/
	
	@Override
	public String allocateProjectToGPM(int gpmid, int pid) throws ProjectException, GramPanchayatException, BdoException {
		String result = "Not allocated ";
		
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from grampanchayat where GPID = ?");
			ps.setInt(1, gpmid);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("select * from project where pid = ?");
				ps2.setInt(1,pid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					PreparedStatement ps3 = conn.prepareStatement("update project set pgpid = ? where pid = ?");
					ps3.setInt(1, gpmid);
					ps3.setInt(2, pid);
					
					int x = ps3.executeUpdate();
					
					if(x > 0) {
						result = "Project with PID ID : " + pid +" Allocated to GPM with GPM ID : " +gpmid ;
						return result;
					}
	
				}else {
					throw new ProjectException("Project don't exist with PID : " + pid);	
				}

				
			}else {
				throw new GramPanchayatException("Gram Panchyat Member don't exist with GPID :" + gpmid);
			}
			
			
			
			
		} catch (SQLException e) {
			throw new BdoException(e.getMessage());
		}

		return result;
	}

	
	/*------------------------------------ Employee On a project  --------------------------------------------------------*/
	
	@Override
	public List<Employee> employeeOnAProject(int pid) throws ProjectException, EmployeeException, BdoException {
		
		List<Employee> empList = new ArrayList<>();
		
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from project where pid =?");
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from employee e inner join project p on e.epid = p.pid where p.pid = ?");
				ps2.setInt(1, pid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				while(rs2.next()) {

					int eid = rs2.getInt("eid");
					int egpid = rs2.getInt("egpid");
					int epid = rs2.getInt("epid");
					String name = rs2.getString("ename");
					String address = rs2.getString("eaddress");
					Date date = rs2.getDate("edate_joined");
					int wage = rs2.getInt("ewage");
					
					
					Employee e = new Employee(eid, egpid, epid, name, address, date, wage);
					empList.add(e);
		
				}
				
			}else {
				throw new ProjectException("No Project found with PID ID : " + pid);
			}
		
		} catch (SQLException e) {
			throw new BdoException(e.getMessage());
		}
		
		if(empList.size() ==0) {
			throw new EmployeeException("Exception : No Employee Found in the given PID : ." + pid);
		}
			
		return empList;
	}
	
	
	
	
	
	
	
}
	


