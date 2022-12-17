package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.main.CustomerMenu;

public class BookTicket {

	public static int seats;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Bus No.:");
		String busNo  = sc.next();
		
		CustomerDao custDao = new CustomerDaoImpl();
		
		try {
			String message = custDao.bookeTicket(busNo, seats);
			
			System.out.println(message);
			System.out.println("-----------------------------------------");
			System.out.println("");
			CustomerMenu.main(args);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			System.out.println("-----------------------------------------");
			System.out.println("");
			BookTicket.main(args);
		}
		

	}

}
