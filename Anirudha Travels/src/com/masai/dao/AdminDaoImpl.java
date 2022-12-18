package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.exception.AdminException;
import com.masai.exception.BusException;
import com.masai.exception.CustomerException;
import com.masai.model.Bus;
import com.masai.model.Customer;
import com.masai.utility.DButil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String loginAdmin(String username, String password) throws AdminException {
		String message = "Admin Not loged in!";
		
		if(username.equals("admin") & password.equals("admin123")) {
				message = "Login Successfully.";
		} else {
			throw new AdminException("Invalid Username or Password!");
		}
		
		return message;
	}

	@Override
	public String addBus(Bus bus) throws BusException {
		String message = "Bus not added!";
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into buses values(?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, bus.getName());
			ps.setString(2, bus.getBus_no());
			ps.setString(3, bus.getType());
			ps.setString(4, bus.getRoute());
			ps.setString(5, bus.getArrival_time());
			ps.setString(6, bus.getDeparture_time());
			ps.setInt(7, bus.getTotal_seats());
			ps.setInt(8, bus.getAvailable_seats());
			ps.setInt(9, bus.getTicket_price());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Bus added successfully.";
			} else {
				throw new BusException("Bus already exists!");
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Bus> showAllBusDetails() throws BusException {
		List<Bus> buses = new ArrayList<>();
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from buses");
						
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Bus bus = new Bus();
				
				bus.setName(rs.getString("bus_name"));
				bus.setBus_no(rs.getString("bus_no"));
				bus.setType(rs.getString("bus_type"));
				bus.setRoute(rs.getString("bus_route"));
				bus.setArrival_time(rs.getString("arrival_time"));
				bus.setDeparture_time(rs.getString("departure_time"));
				bus.setTotal_seats(rs.getInt("total_seats"));
				bus.setAvailable_seats(rs.getInt("available_seats"));
				bus.setTicket_price(rs.getInt("ticket_price"));
				
				buses.add(bus);
			}
			
			if(buses.size() == 0) {
				throw new BusException("No buses found!");
			}
			
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}		
		
		return buses;
	}

	@Override
	public Customer confirmTicket() throws BusException {
		Customer cust = new Customer();
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select bs.booking_id, bs.email, bs.booked_seats, b.bus_name, b.bus_no, b.bus_route from booking_status bs INNER JOIN buses b ON b.bus_no = bs.bus_no AND confirm_status = 0");
			
			ResultSet rs = ps.executeQuery();
			int count = 1;
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				if(count == 1) {
					System.out.printf("+------------+---------------------------+--------------+----------------------+------------+-------------------------+%n");
					System.out.printf("| %-10s | %-25s | %-12s | %-20s | %-10s | %-23s |%n", "Booking ID", "Email", "Booked Seats", "Bus Name", "Bus No", "Bus Route");
					System.out.printf("+------------+---------------------------+--------------+----------------------+------------+-------------------------+%n");
					count++;
				}
				System.out.printf("| %-10s | %-25s | %-12s | %-20s | %-10s | %-23s |%n", rs.getInt("booking_id"), rs.getString("email"), rs.getString("booked_seats"),rs.getString("bus_name"), rs.getString("bus_no"), rs.getString("bus_route"));
			}
			if(count==2) {
				System.out.printf("+------------+---------------------------+--------------+----------------------+------------+-------------------------+%n");
			}
			if(flag) {
				Scanner sc = new Scanner(System.in);
				System.out.println("");
				System.out.println("To confirm ticket");
				System.out.println("Enter Booking ID:");
				int bid = sc.nextInt();
				
				PreparedStatement ps1 = conn.prepareStatement("update booking_status set confirm_status = 1 where booking_id = ?");
				ps1.setInt(1, bid);
				
				int x = ps1.executeUpdate();
				
				if(x > 0) {
					PreparedStatement ps3 = conn.prepareStatement("select booked_seats from booking_status where booking_id = ?");
					ps3.setInt(1, bid);
					
					ResultSet rs3 = ps3.executeQuery();
					
					if(rs3.next()) {
						PreparedStatement ps4 = conn.prepareStatement("update buses set available_seats = available_seats - ? where bus_no = (select bus_no from booking_status where booking_id = ?)");
						ps4.setInt(1, rs3.getInt("booked_seats"));
						ps4.setInt(2, bid);
						
						int k = ps4.executeUpdate();
						if(k>0) {
							System.out.println("");
							System.out.println("Booking confirmed.");
							
							PreparedStatement ps2 = conn.prepareStatement("select * from customers where email = (select email from booking_status where booking_id = ?)");
							ps2.setInt(1, bid);
							
							ResultSet rs2 = ps2.executeQuery();
							
							if(rs2.next()) {
								cust.setName(rs2.getString("name"));
								cust.setAge(rs2.getInt("age"));
								cust.setAddress(rs2.getString("address"));
								cust.setPhone(rs2.getString("phone_no"));
								cust.setEmail(rs2.getString("email"));
							} else {
								throw new BusException("Customer not found!");
							}
						}
					}
					
					
				} else {
					throw new BusException("ticket not confirmed.");
				}
			} else {
				throw new BusException("No ticket confirmation pendings.");
			}
				
		} catch (SQLException e) {
			throw new BusException(e.getMessage());
		}
		
		return cust;
	}

	@Override
	public String logout() throws AdminException {
			
			return "Thank You for visiting!";
	}

	
}
