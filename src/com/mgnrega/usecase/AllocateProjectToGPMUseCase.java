package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.BdoImplementation;
import com.mgnrega.dao.BdoInterface;
import com.mgnrega.exception.BdoException;
import com.mgnrega.exception.GramPanchayatException;
import com.mgnrega.exception.ProjectException;

public class AllocateProjectToGPMUseCase {
	
	public static void allocateProjectToGPM() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project ID to assign : ");
		int pid = sc.nextInt();
		System.out.println("Enter Gram Panchayat Member ID to assign : ");
		int gpid = sc.nextInt();
		
		BdoInterface dao = new BdoImplementation();
		String result;
		
		try {
			result = dao.allocateProjectToGPM(gpid, pid);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (ProjectException e) {
			
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
		} catch (GramPanchayatException e) {
			
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
		} catch (BdoException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		}
		
		
		//sc.close();
		
		
		
	}

}
