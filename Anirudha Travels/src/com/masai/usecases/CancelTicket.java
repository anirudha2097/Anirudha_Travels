package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;

public class CancelTicket {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String username = sc.next();
 		
		CustomerDao custDao = new CustomerDaoImpl();
		
		try {
			String message = custDao.cancelTicket(username);
			System.out.println(message);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
