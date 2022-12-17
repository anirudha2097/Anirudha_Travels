package com.masai.dao;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.BusException;
import com.masai.exception.CustomerException;
import com.masai.model.Bus;
import com.masai.model.Customer;

public interface AdminDao {
	
	public String loginAdmin(String username, String password) throws AdminException;
	
	public String addBus(Bus bus) throws BusException;
	
	public List<Bus> showAllBusDetails() throws BusException;
	
	public Customer confirmTicket() throws BusException;
	
	public String logout() throws AdminException;
	
}
