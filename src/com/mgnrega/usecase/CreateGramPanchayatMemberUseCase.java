package com.mgnrega.usecase;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mgnrega.custom.ConsoleColors;
import com.mgnrega.dao.BdoImplementation;
import com.mgnrega.dao.BdoInterface;
import com.mgnrega.exception.CredentialException;
import com.mgnrega.exception.GramPanchayatException;
import com.mgnrega.model.GramPanchayat;

public class CreateGramPanchayatMemberUseCase {
	
	public static boolean flag = false;
	
	public static void createGramPanchayatMember()  {
		
		Scanner sc = new Scanner(System.in);
		
//		List<Character> specialCharList = Arrays.asList('~','!','@','#','$','%','^','&','*','_','-','+','=','/','<','>','?',',','`');
//		List<Integer> integerList = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		
		
		try {
			
			
			System.out.println("Enter Gram Panchayat Member Name : ");
			String name = sc.nextLine();
			System.out.println("Enter Gram Panchayat Member Address : ");
			String address = sc.nextLine();
			System.out.println("Enter Gram Panchayat Member Phone Number : ");
			long phNumber = sc.nextLong();
			sc.nextLine();
			String phone = Long.toString(phNumber);
			System.out.println("Enter Gram Panchayat Member Password : ");
			System.out.println(ConsoleColors.BLUE_ITALIC+"(Password must contain 8 characters and should have atleast 1 Upper Case, 1 Small Case, 1 Number and 1 Special Character)"+ ConsoleColors.RESET);
			boolean flag = false;
			String password = null;
			while(!flag) {
				password = sc.nextLine();
				flag = password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
				
				if(flag) {
					break;
				}
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Invalid Password Pattern" + ConsoleColors.RESET);
				System.out.println(ConsoleColors.RED_ITALIC+"(Password must contain 8 characters and should have atleast 1 Upper Case, 1 Small Case, 1 Number and 1 Special Character)"+ ConsoleColors.RESET);
			}
			
			
			
			GramPanchayat g = new GramPanchayat();
			g.setGname(name);
			g.setAddress(address);
			g.setGphone(phone);
			g.setPassword(password);
			
			BdoInterface dao = new BdoImplementation();
			String result;
			
			
			try {
				result = dao.createGramPanchayatMember(g);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			} catch (GramPanchayatException e) {
				result = e.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			}	
			
		} catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
		
		
		//sc.close();
		
		
	}

}
