package com.mgnrega.usecase;



import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.BdoImplementation;
import com.mgnrega.dao.BdoInterface;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Project;

public class CreateProjectUseCase {
	
	public static void createProject() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			
			System.out.println("Enter Project Name : ");
			String name = sc.nextLine();
			System.out.println("Enter Project Cost : ");
			int cost = sc.nextInt();
			System.out.println("Enter Project Duration :");
			int duration = sc.nextInt();
			
			Project p = new Project();
			p.setPname(name);
			p.setPcost(cost);
			p.setDuration(duration);
			
			BdoInterface dao = new BdoImplementation();
			String result;
			
			try {
				result = dao.createProject(p);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);

			} catch (ProjectException e) {
				result = e.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
			}
			
		} catch (InputMismatchException i) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
		

		//sc.close();
		
		
	}
	
	
	

}
