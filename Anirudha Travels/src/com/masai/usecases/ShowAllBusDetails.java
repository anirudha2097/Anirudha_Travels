package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.BusException;
import com.masai.exception.CustomerException;
import com.masai.model.Bus;
import com.masai.model.Customer;

public class ShowAllBusDetails {

	public static void main(String[] args) {
		
		AdminDao adminDao = new AdminDaoImpl();
		
		try {
			List<Bus> buses = adminDao.showAllBusDetails();
				
			buses.forEach(s -> System.out.println(s));
	
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
