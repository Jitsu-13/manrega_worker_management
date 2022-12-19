package com.mgnrega.usecase;

import java.util.List;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.BdoImplementation;
import com.mgnrega.dao.BdoInterface;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.model.Project;

public class DisplayAllProjectUseCase {
	
	public static void displayProject() {
		
		BdoInterface dao = new BdoImplementation();
		
		try {
			List<Project> projects = dao.displayAllProject();
			
			System.out.println("---------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Projects Present" + ConsoleColors.RESET+ "---------------------");
			
			System.out.println("---------------------------------------------------------------------");
			
			System.out.printf("%7s %7.5s %16s %15s %17s",ConsoleColors.BLACK_BOLD + "PID", "GPMID", "NAME", "COST", "DURATION" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------");
			
			System.out.println();
			for(Project p: projects) {
				
				System.out.format("%2s %6s %22s %12s %11s",p.getPid(),p.getPgpid(), p.getPname(),p.getPcost(),p.getDuration() + " Days");
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------------------");
	
		} catch (ProjectException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
	}

}
