package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.CustomerException;
import com.masai.model.Bus;
import com.masai.model.Customer;

public class SeeBusRoutes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Source:");
		String source = sc.next();
		
		System.out.println("Enter Destination:");
		String destination = sc.next();
				
		System.out.println("Enter No. of Seats:");
		int seats = sc.nextInt();
		
		CustomerDao custDao = new CustomerDaoImpl();
		
		try {
			List<Bus> buses = custDao.showBuses(source, destination, seats);
			
			buses.forEach(s -> System.out.println(s));
			
			if(buses.size()>0) {

				System.out.println("Enter Bus No.:");
				String busNo  = sc.next();
				
				String message = custDao.bookeTicket(busNo, seats);
				
				System.out.println(message);
			}
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
