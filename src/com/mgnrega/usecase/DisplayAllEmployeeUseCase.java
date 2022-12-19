package com.mgnrega.usecase;

import java.util.List;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.BdoImplementation;
import com.mgnrega.dao.BdoInterface;
import com.mgnrega.dao.GPMImplementation;
import com.mgnrega.dao.GPMInterface;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.Project;

public class DisplayAllEmployeeUseCase {
	public static void displayEmployee() {
		
		GPMInterface dao =new GPMImplementation();
		
		try {
			List<Employee> emp = dao.displayAllEmployee();
			
			System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee Present" + ConsoleColors.RESET+ "---------------------------");
			
			System.out.println("---------------------------------------------------------------------------------");
			
			System.out.printf("%7s %7.5s %8.5s %10s %15s %17s %16s",ConsoleColors.BLACK_BOLD + "EID", "EGPMID","EPID", "NAME", "ADDRESS", "DATE JOINED", "WAGE/DAY" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------------------");
			
			System.out.println();
			for(Employee e : emp) {
				
				System.out.format("%2s %6s %8.5s %13s %14s %16s %10s",e.getEid(),e.getEgpid(),e.getEpid(),e.getEname(),e.getEaddress(),e.getEdate(),e.getEwage());
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------------------------------");
	
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
	}
}
