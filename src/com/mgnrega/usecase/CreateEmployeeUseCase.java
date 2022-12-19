package com.mgnrega.usecase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.BdoImplementation;
import com.mgnrega.dao.BdoInterface;
import com.mgnrega.dao.GPMImplementation;
import com.mgnrega.dao.GPMInterface;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.Project;

public class CreateEmployeeUseCase {
//	public static int loginID = GPMImplementation.storedGpmID;
	public static void createEmployee() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			
			System.out.println("Enter Employee Name : ");
			String name = sc.nextLine();
			
			System.out.println("Enter Employee Address : ");
			String address = sc.nextLine();
			System.out.println("Enter Employee Wage/day : ");
			int wage = sc.nextInt();
			
			Employee e = new Employee();
			e.setEgpid(GPMImplementation.storedGpmID);
			e.setEaddress(address);
			e.setEname(name);
			e.setEwage(wage);
			//System.out.println(e);
			GPMInterface dao = new GPMImplementation();
			String result;
			
			try {
				result = dao.createEmployee(e);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);

			} catch (EmployeeException emp) {
				result = emp.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
			}
			
		} catch (InputMismatchException i) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
		

		//sc.close();
		
		
	}

}
