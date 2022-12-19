package com.mgnrega.usecase;

import java.util.List;
import java.util.Scanner;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.BdoImplementation;
import com.mgnrega.dao.BdoInterface;
import com.mgnrega.exception.BdoException;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Employee;

public class EmployeeOnAProjectUseCase {
	
	public static void employeeOnAProject() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project ID to see the list of all employeein that project : ");
		int pid = sc.nextInt();
		
		
		BdoInterface dao = new BdoImplementation();
		
		try {
			List<Employee> emp =  dao.employeeOnAProject(pid);
			
			System.out.println("--" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee Present in the Project ID : " +pid + ConsoleColors.RESET+ "----");
			
			System.out.println("-------------------------------------------------------------");
			
			System.out.printf("%17s %10.5s %19s",ConsoleColors.BLACK_BOLD + "EID","NAME","WAGE/DAY"  +ConsoleColors.RESET);
			System.out.println();
			System.out.print("-------------------------------------------------------------");
			
			System.out.println();
			for(Employee e : emp) {
				
				System.out.format("%9.2s %13s %10s",e.getEid(),e.getEname(),e.getEwage());
				System.out.println();
			}
			
			System.out.println("-------------------------------------------------------------");
			
			
			
			
		} catch (ProjectException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		} catch (BdoException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
		
		
		
		
	}

}
