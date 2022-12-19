package com.mgnrega.usecase;

import java.util.List;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.BdoImplementation;
import com.mgnrega.dao.BdoInterface;
import com.mgnrega.exception.GramPanchayatException;
import com.mgnrega.model.GramPanchayat;
import com.mgnrega.model.Project;

public class DisplayAllGramPayanchayatMemberUseCase {
	
	
	public static void displayAllGPM() {
		
		BdoInterface dao = new BdoImplementation();
		
		try {
			List<GramPanchayat> gpmList = dao.displayAllGramPayanchayatMember();
			
			
			System.out.println("------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all Gram Panchayat Member Present" + ConsoleColors.RESET+ "---------------");
			
			System.out.println("---------------------------------------------------------------------");
			
			System.out.printf("%7s %12s %16s %12.5s %19s",ConsoleColors.BLACK_BOLD + "GPID", "NAME", "ADDRESS", "PHONE", "PASSWORD" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------");
			
			System.out.println();
			for(GramPanchayat g : gpmList) {
				
				System.out.format("%2s %15s %14s %15s %14s",g.getGpid(),g.getGname(),g.getAddress(),g.getGphone(),g.getPassword());
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------------------");
		} catch (GramPanchayatException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
	}

}
