package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.CancelTicket;
import com.masai.usecases.LogoutCustomer;
import com.masai.usecases.SeeBusRoutes;
import com.masai.usecases.ShowBookingHistory;

public class CustomerMenu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("Selct from following option");
		System.out.println("===========================");
		System.out.println("1. Search Bus");
		System.out.println("2. Booking History");
		System.out.println("3. Cancel Ticket");
		System.out.println("4. Logout");
		System.out.println("99. Main Menu");
		int i = sc.nextInt();
		System.out.println("");
		switch(i) {
			case 1: SeeBusRoutes.main(args);
			break;
			case 2: ShowBookingHistory.main(args);
			break;
			case 3: CancelTicket.main(args);
			break;
			case 4: LogoutCustomer.main(args);
			break;
			case 99: Main.main(args);
			break;
		}

	}

}
