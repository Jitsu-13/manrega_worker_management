package com.mgnrega.main;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.usecase.AssignEmployeeToProjectUseCase;
import com.mgnrega.usecase.BdoLoginUseCase;
import com.mgnrega.usecase.CreateEmployeeUseCase;
import com.mgnrega.usecase.DisplayAllEmployeeUseCase;
import com.mgnrega.usecase.EmployeedaysAndWageUseCase;
import com.mgnrega.usecase.GPMLoginUseCase;

public class GpmMain {
	
	
		
//		GPMLoginUseCase login = new GPMLoginUseCase();
//		boolean res =login.gpmLogin();
//		
//		
//		CreateEmployeeUseCase createEmp = new CreateEmployeeUseCase();
//		createEmp.createEmployee();
//		
		
//		DisplayAllEmployeeUseCase displayEmp = new DisplayAllEmployeeUseCase();
//		displayEmp.displayEmployee();
		
//		AssignEmployeeToProjectUseCase assignEmployee = new AssignEmployeeToProjectUseCase();
//		assignEmployee.assignEmployeeToProject();
		
//		EmployeedaysAndWageUseCase dayWage = new EmployeedaysAndWageUseCase();
//		dayWage.employeedaysAndWage();
		
		
		
		
	public static boolean GpmLogin() {
		GPMLoginUseCase login = new GPMLoginUseCase();
		boolean result =login.gpmLogin();
		return result;	
	}
	
	public static void gpmWindow() {
		
		System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Gram Panchayat Member Home Window : "+ ConsoleColors.RESET);
		System.out.println("Press 1 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Create a Employee." + ConsoleColors.RESET);
		System.out.println("Press 2 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View Detail List of all Employee." + ConsoleColors.RESET);
		System.out.println("Press 3 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Assingn Employee to a Project." + ConsoleColors.RESET);
		System.out.println("Press 4 to"+ConsoleColors.PURPLE_BOLD_BRIGHT+" View deatil of all Employees Working along with wages, day worked and Total Receivable Amount Till Current Day." + ConsoleColors.RESET);
		System.out.println("Press 5 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);
	}
	
	
	
	public static void createEmployee() {
		CreateEmployeeUseCase createEmp = new CreateEmployeeUseCase();
		createEmp.createEmployee();
	}
	
	public static void displayEmployee() {
		DisplayAllEmployeeUseCase displayEmp = new DisplayAllEmployeeUseCase();
		displayEmp.displayEmployee();	
	}
	
	public static void assignEmployee() {
		AssignEmployeeToProjectUseCase assignEmployee = new AssignEmployeeToProjectUseCase();
		assignEmployee.assignEmployeeToProject();
	}
	
	public static void dayWageTotal() {
		EmployeedaysAndWageUseCase dayWage = new EmployeedaysAndWageUseCase();
		dayWage.employeedaysAndWage();
	}
		
		
	
}
