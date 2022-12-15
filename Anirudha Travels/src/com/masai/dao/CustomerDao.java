package com.masai.dao;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.model.BookingHistory;
import com.masai.model.Bus;
import com.masai.model.Customer;

public interface CustomerDao {

	public String registerCustomer(Customer cust) throws CustomerException;
	
	public Customer loginCustomer(String username, String password) throws CustomerException;
	
	public List<Bus> showBuses(String source, String destination, int seats) throws CustomerException;

	public String bookeTicket(String busNo, int seats) throws CustomerException;
	
	public String cancelTicket(String username) throws CustomerException;
	
	public List<BookingHistory> bookingHistory(String username) throws CustomerException;

	public String logout() throws CustomerException;
}
