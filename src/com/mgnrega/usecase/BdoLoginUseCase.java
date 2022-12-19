package com.mgnrega.usecase;

import java.util.Scanner;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.BdoImplementation;
import com.mgnrega.dao.BdoInterface;
import com.mgnrega.exception.CredentialException;

public class BdoLoginUseCase {
	
	public static boolean bdoLogin() {
			
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username : ");
		String username = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		//sc.close();
		BdoInterface dao = new BdoImplementation();
		
		String result;
		
		try {
			result = dao.bdologin(username, password);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return true;
			
			
		} catch (CredentialException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
		}
		
		
				
		
	}

}
