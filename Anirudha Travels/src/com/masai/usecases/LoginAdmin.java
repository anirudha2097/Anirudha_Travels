package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.BusException;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public class LoginAdmin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Username:");
		String username = sc.next();
		
		System.out.println("Enter Password:");
		String password = sc.next();
		
		
		AdminDao adminDao = new AdminDaoImpl();
		
		try {
			String result = adminDao.loginAdmin(username, password);
			
//			System.out.println("+-------------------------------------------+");
//			System.out.println("| *******WELCOME TO ANIRUDHA TRAVELS******* |");
//			System.out.println("+-------------------------------------------+");
			
			System.out.println(result);
			
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
