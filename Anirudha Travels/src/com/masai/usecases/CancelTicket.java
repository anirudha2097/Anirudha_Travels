package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.main.CustomerMenu;

public class CancelTicket {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Username: ");
//		String username = sc.next();
 		
		CustomerDao custDao = new CustomerDaoImpl();
		
		try {
			String message = custDao.cancelTicket();
			System.out.println(message);
			System.out.println("-----------------------------------------");
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
