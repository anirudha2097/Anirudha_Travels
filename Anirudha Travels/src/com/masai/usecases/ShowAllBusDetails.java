package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.BusException;
import com.masai.exception.CustomerException;
import com.masai.main.AdminMenu;
import com.masai.model.Bus;
import com.masai.model.Customer;

public class ShowAllBusDetails {

	public static void main(String[] args) {
		
		AdminDao adminDao = new AdminDaoImpl();
		
		try {
			List<Bus> buses = adminDao.showAllBusDetails();
				
			if(buses.size()>0) {
				System.out.printf("+----------------------+------------+--------+-------------------------+----------------+----------------+-------------+-----------------+--------------+%n");
				System.out.printf("| %-20s | %-10s | %-6s | %-23s | %-14s | %-14s | %-11s | %-15s | %-12s |%n", "Bus Name", "Bus No", "Type", "Route", "Arrival Time", "Departure Time", "Total Seats", "Available Seats", "Ticket Price");
				System.out.printf("+----------------------+------------+--------+-------------------------+----------------+----------------+-------------+-----------------+--------------+%n");
				
			}
			buses.forEach(s -> {
				System.out.printf("| %-20s | %-10s | %-6s | %-23s | %-14s | %-14s | %-11s | %-15s | %-12s |%n", s.getName(), s.getBus_no(), s.getType(), s.getRoute(), s.getArrival_time(), s.getDeparture_time(), s.getTotal_seats(), s.getAvailable_seats(), s.getTicket_price());
			});
			if(buses.size()>0) {
				System.out.printf("+----------------------+------------+--------+-------------------------+----------------+----------------+-------------+-----------------+--------------+%n");
				
			}
			System.out.println("");
			AdminMenu.main(args);
		} catch (BusException e) {
			System.out.println(e.getMessage());
			System.out.println("-----------------------------------------");
			System.out.println("");
			AdminMenu.main(args);
		}
	
	}

}
