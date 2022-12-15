package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public class LoginCustomer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Username:");
		String username = sc.next();
		
		System.out.println("Enter Password:");
		String password = sc.next();
		
		
		CustomerDao custDao = new CustomerDaoImpl();
		
		try {
			Customer cust = custDao.loginCustomer(username, password);
//			System.out.println("+-------------------------------------------+");
//			System.out.println("| *******WELCOME TO ANIRUDHA TRAVELS******* |");
//			System.out.println("+-------------------------------------------+");
			
			System.out.println("Welcome "+cust.getName().toUpperCase()+"!");
			System.out.println("");
			System.out.println("Name: "+cust.getName());
			System.out.println("Age: "+cust.getAge());
			System.out.println("Address: "+cust.getAddress());
			System.out.println("Phone No.: "+cust.getPhone());
			System.out.println("Email: "+cust.getEmail());
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
