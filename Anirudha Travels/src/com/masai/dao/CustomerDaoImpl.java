package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.exception.CustomerException;
import com.masai.model.BookingHistory;
import com.masai.model.Bus;
import com.masai.model.Customer;
import com.masai.utility.DButil;

public class CustomerDaoImpl implements CustomerDao {

	public static String email;
	
	@Override
	public String registerCustomer(Customer cust) throws CustomerException {
		String message = "Customer Not Registered!";
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into customers values(?,?,?,?,?,?)");
			
			ps.setString(1, cust.getName().toUpperCase());
			ps.setInt(2, cust.getAge());
			ps.setString(3, cust.getAddress().toUpperCase());
			ps.setString(4, cust.getPhone());
			ps.setString(5, cust.getEmail());
			ps.setString(6, cust.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Customer Registered Successfully.";
			} else {
				throw new CustomerException(message);
			}
			
		} catch (SQLException e) {
			throw new CustomerException("Customer already exists!");
		}
		
		return message;
	}

	@Override
	public Customer loginCustomer(String username, String password) throws CustomerException {
		Customer cust = new Customer();
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from customers where email=? AND password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cust.setName(rs.getString("name"));
				cust.setAge(rs.getInt("age"));
				cust.setAddress(rs.getString("address"));
				cust.setPhone(rs.getString("phone_no"));
				cust.setEmail(rs.getString("email"));
				cust.setPassword(rs.getString("password"));
				email = username;
			} else {
				throw new CustomerException("Invalid username or password!");
			}
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return cust;
	}

	@Override
	public List<Bus> showBuses(String source, String destination, int seats) throws CustomerException {
		List<Bus> buses = new ArrayList<>();
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from buses where bus_route = ? AND available_seats >= ?");
	
			String route = source+"-"+destination;
			
			ps.setString(1, route);
			ps.setInt(2, seats);
			
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
				throw new CustomerException("No buses available for this route!");
			}
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return buses;
	}

	@Override
	public String bookeTicket(String busNo, int seats) throws CustomerException {
		String message = "Seats are not booked!";
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into booking_status(email, booked_seats, bus_no) values (?,?,?)");
			
			ps.setString(1, email);
			ps.setInt(2, seats);
			ps.setString(3, busNo);
			
			int x = ps.executeUpdate();
			 
			if(x > 0) {
				message = "Wait for the seat confirmation...";
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}

		return message;
	}

	@Override
	public String cancelTicket() throws CustomerException {
		
		String message = "Ticket not canceled!";
		
		try (Connection conn = DButil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select bs.booking_id, b.bus_name, b.bus_no, b.bus_route from booking_status bs INNER JOIN buses b ON b.bus_no = bs.bus_no AND email = ?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			boolean flag = false;
			int count = 1;
			while(rs.next()) {
				flag = true;
				if(count == 1) {
					System.out.printf("+------------+----------------------+------------+-------------------------+%n");
					System.out.printf("| %-10s | %-20s | %-10s | %-23s |%n", "Booking ID", "Bus Name", "Bus No", "Bus Route");
					System.out.printf("+------------+----------------------+------------+-------------------------+%n");
					count++;
				}
				System.out.printf("| %-10s | %-20s | %-10s | %-23s |%n", rs.getInt("booking_id"), rs.getString("bus_name"), rs.getString("bus_no"), rs.getString("bus_route"));
			}
			if(count==2) {
				System.out.printf("+------------+----------------------+------------+-------------------------+%n");
			}
			if(flag) {
				Scanner sc = new Scanner(System.in);
				System.out.println("");
				System.out.println("To cancel ticket");
				System.out.println("Enter Booking ID:");
				int bookingId = sc.nextInt();
				
				PreparedStatement ps1 = conn.prepareStatement("delete from booking_status where booking_id = ?");
				ps1.setInt(1, bookingId);
				
				int x = ps1.executeUpdate();
				if(x>0) {
					message = "Ticket cancelled successful";
				} else {
					throw new CustomerException("Please enter correct booking id.");
				}
			} else {
				throw new CustomerException("No bookings found!");
			}
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<BookingHistory> bookingHistory() throws CustomerException {
		List<BookingHistory> bookingList = new ArrayList<>();
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select b.bus_name, b.bus_route, b.ticket_price, bs.booked_seats from buses b INNER JOIN booking_status bs ON b.bus_no = bs.bus_no AND bs.email = ?");
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BookingHistory booking = new BookingHistory();
				booking.setBusName(rs.getString("bus_name"));
				booking.setRoute(rs.getString("bus_route"));
				booking.setTicketPrice(rs.getInt("ticket_price"));
				booking.setSeats(rs.getInt("booked_seats"));
				
				bookingList.add(booking);
			}
			 
			if(bookingList.size() == 0) {
				throw new CustomerException("No bookings found!");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
			
		return bookingList;
	}

	@Override
	public String logout() throws CustomerException {
		
		email = null;
		
		return "Thank You for visiting!";
	}
	
	

}
