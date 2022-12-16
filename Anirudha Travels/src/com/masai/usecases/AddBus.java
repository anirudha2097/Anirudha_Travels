package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exception.BusException;
import com.masai.exception.CustomerException;
import com.masai.model.Bus;
import com.masai.model.Customer;

public class AddBus {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Bus Name:");
		String name = sc.nextLine();

		System.out.println("Enter Bus No:");
		String busNo = sc.next();
		
		System.out.println("Enter Bus Type:");
		System.out.println(" 1. AC");
		System.out.println(" 2. Non AC");
		
		int type = sc.nextInt();
		
		System.out.println("Enter Bus Starting Point");
		String source = sc.next();
		System.out.println("Enter Bus Destination:");
		String destination = sc.next();
		String route = source+"-"+destination;
		
		System.out.println("Enter Arrival Time(hh:mm:ss):");
		String arrivalTime = sc.next();
		System.out.println("Enter Departure Time(hh:mm:ss):");
		String departureTime = sc.next();
		
		System.out.println("Enter No. of Seats:");
		int seats = sc.nextInt();
		
		System.out.println("Enter Ticket Price:");
		int price = sc.nextInt();
		
		Bus bus = new Bus();
		bus.setName(name.toUpperCase());
		bus.setBus_no(busNo.toUpperCase());
		if(type == 1) {
			bus.setType("AC");
		} else {
			System.out.println("Non AC");
		}
		bus.setRoute(route.toUpperCase());
		bus.setArrival_time(arrivalTime);
		bus.setDeparture_time(departureTime);
		bus.setTotal_seats(seats);
		bus.setAvailable_seats(seats);
		bus.setTicket_price(price);
		
		
		AdminDao adminDao = new AdminDaoImpl();
		
		try {
			String result = adminDao.addBus(bus);
			System.out.println(result);
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
	}

}
