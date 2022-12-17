package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.main.CustomerMenu;
import com.masai.model.Bus;
import com.masai.model.Customer;

public class SeeBusRoutes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Source:");
		String source = sc.next();
		
		System.out.println("Enter Destination:");
		String destination = sc.next();
				
		System.out.println("Enter No. of Seats:");
		int seats = sc.nextInt();
		
		CustomerDao custDao = new CustomerDaoImpl();
		
		try {
			List<Bus> buses = custDao.showBuses(source, destination, seats);
			
			buses.forEach(s -> System.out.println(s));
			
			if(buses.size()>0) {

				System.out.println("1. Book Ticket");
				System.out.println("2. Back To Menu");
				int i = sc.nextInt();
				BookTicket.seats = seats;
				switch (i) {
					case 1: BookTicket.main(args);
					break;
					case 2: CustomerMenu.main(args);
					break;
				}
			}
			System.out.println("-----------------------------------------");
			System.out.println("");
			CustomerMenu.main(args);
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			System.out.println("-----------------------------------------");
			System.out.println("");
			CustomerMenu.main(args);
		}
	
		sc.close();
	}

}
