package com.masai.usecases;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.main.CustomerMenu;
import com.masai.main.Main;

public final class LogoutCustomer {

	public static void main(String[] args) {
		
		CustomerDao cust = new CustomerDaoImpl();
		
		try {
			String result = cust.logout();
			System.out.println("-----------------------------------------");
			System.out.println("");
			Main.main(args);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
			System.out.println("-----------------------------------------");
			System.out.println("");
			CustomerMenu.main(args);
		}

	}

}
