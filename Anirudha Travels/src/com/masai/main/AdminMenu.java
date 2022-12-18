package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.AddBus;
import com.masai.usecases.ConfirmTicket;
import com.masai.usecases.ExitApp;
import com.masai.usecases.LogoutAdmin;
import com.masai.usecases.ShowAllBusDetails;

public class AdminMenu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select from following option");
		System.out.println("============================");
		System.out.println("1. Add Bus");
		System.out.println("2. Show all bus details");
		System.out.println("3. Confirm customers ticket");
		System.out.println("4. Logout");
		System.out.println("99. Exit Application.");
		int i = sc.nextInt();
		System.out.println("");
		
		switch (i) {
			case 1: AddBus.main(args);
			break;
			case 2: ShowAllBusDetails.main(args);
			break;
			case 3: ConfirmTicket.main(args);
			break;
			case 4: LogoutAdmin.main(args);
			break;
			case 99: ExitApp.main(args);
			break;
		}
		
		sc.close();

	}

}
