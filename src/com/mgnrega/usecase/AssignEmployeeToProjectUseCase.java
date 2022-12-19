package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.GPMImplementation;
import com.mgnrega.dao.GPMInterface;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.GramPanchayatException;
import com.mgnrega.exception.ProjectException;

public class AssignEmployeeToProjectUseCase {
	
	public static void assignEmployeeToProject() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project ID to assign : ");
		int pid = sc.nextInt();
		System.out.println("Enter Employee ID to assign : ");
		int eid = sc.nextInt();
		
		
		GPMInterface dao = new GPMImplementation();
		String result;
		
		try {
			result = dao.assignEmployeeToProject(pid, eid);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (EmployeeException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (ProjectException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (GramPanchayatException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		}
		
		//sc.close();
		
		
	}
	
	
	

}
