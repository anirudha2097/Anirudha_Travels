package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.main.CustomerMenu;
import com.masai.model.BookingHistory;
import com.masai.model.Bus;

public class ShowBookingHistory {

	public static void main(String[] args) {
				
		CustomerDao custDao = new CustomerDaoImpl();
		
		try {
			List<BookingHistory> history = custDao.bookingHistory();
			
			if(history.size()>0) {
				System.out.println("+------------+----------------------+-------+--------------+");
				System.out.printf("| %-10s | %-20s | %-5s | %-12s |%n", "Bus No", "Route", "Seats", "Ticket Price");
				System.out.println("+------------+----------------------+-------+--------------+");
			}
			history.forEach(s -> {
				System.out.printf("| %-10s | %-20s | %-5s | %-12s |%n", s.getBusName(), s.getRoute(), s.getSeats(), s.getTicketPrice());
			});
			if(history.size()>0) {
				System.out.println("+------------+----------------------+-------+--------------+");
			}
			System.out.println("");
			CustomerMenu.main(args);
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			System.out.println("-----------------------------------------");
			System.out.println("");
			CustomerMenu.main(args);
		}

//		sc.close();
	}

}
