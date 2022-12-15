package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.model.BookingHistory;
import com.masai.model.Bus;

public class ShowBookingHistory {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String username = sc.next();
		

		CustomerDao custDao = new CustomerDaoImpl();
		
		try {
			List<BookingHistory> history = custDao.bookingHistory(username);
			
			history.forEach(s -> System.out.println(s));
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

	}

}
