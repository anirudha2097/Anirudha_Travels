package com.masai.usecases;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.BusException;
import com.masai.model.Customer;

public class ConfirmTicket {

	public static void main(String[] args) {
		
		AdminDao adminDao = new AdminDaoImpl();
		
		try {
			Customer cust = adminDao.confirmTicket();
			System.out.println(cust);
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}

		
	}

}
