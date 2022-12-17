package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.main.CustomerMain;
import com.masai.main.CustomerMenu;
import com.masai.model.Customer;

public class RegisterCustomer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Name:");
		String name = sc.nextLine();
		
		System.out.println("Enter Age:");
		int age = sc.nextInt();
		
		System.out.println("Enter Address:");
		sc.nextLine();
		String address = sc.nextLine();
		
		System.out.println("Enter Phone No.:");
		String phone = sc.next();
		
		System.out.println("Enter Email:");
		String email = sc.next();
		
		System.out.println("Enter Password(8 characters only):");
		String password = sc.next();
		if(password.length()>=9) {
			password = null;
			System.out.println("Please enter 8 characters password:");
			password = sc.next();
		}

		Customer customer = new Customer();
		customer.setName(name);
		customer.setAge(age);
		customer.setAddress(address);
		customer.setPhone(phone);
		customer.setEmail(email);
		customer.setPassword(password);
		
		CustomerDao custDao = new CustomerDaoImpl();
		
		try {
			String message = custDao.registerCustomer(customer);
			
			System.out.println(message);
			System.out.println("-----------------------------------------");
			System.out.println("");
			System.out.println("Login");
			LoginCustomer.main(args);
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			System.out.println("-----------------------------------------");
			System.out.println("");
			CustomerMain.main(args);
		}
		
		sc.close();
	}

}
