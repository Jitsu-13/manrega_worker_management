package com.mgnrega.usecase;

import java.util.List;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.GPMImplementation;
import com.mgnrega.dao.GPMInterface;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.model.EmployeeWageOperationDTO;
import com.mgnrega.model.Project;

public class EmployeedaysAndWageUseCase {
	
	public static void employeedaysAndWage() {
		
		
		GPMInterface dao = new GPMImplementation();
		
		try {
			List<EmployeeWageOperationDTO> empWage =  dao.employeedaysAndWage();
			
			
			System.out.println("---------------------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee, Wage, days, Total Amount" + ConsoleColors.RESET+ "-------------------------------------");
			
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			
			System.out.printf("%7s %10s %11s %17s %22s %17s %13s %21s",ConsoleColors.BLACK_BOLD + "EID", "ENAME", "PID", "PNAME", "DATE_JOINED", "TOTAL DAYS", "WAGE/DAY", "TOTAL_AMOUNT" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("-------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println();
			for(EmployeeWageOperationDTO e : empWage) {
				
				System.out.format("%2s %12s %9s %22s %17s %14s %14s %18s",e.getEid(),e.getName(), e.getProjectID(),e.getProjectName(),e.getDate_joined(),e.getNoOfDays(),e.getWage(),e.getTotalAmount());
				System.out.println();
			}
			
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
			
			
			
			
			
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
		
		
	}

}
