package com.masai.model;

import java.sql.Time;

public class Bus {

	private String name;
	private String bus_no;
	private String type;
	private String route;
	private String arrival_time;
	private String departure_time;
	private int total_seats;
	private int available_seats;
	private int ticket_price;
	
	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public Bus(String name, String bus_no, String type, String route, String arrival_time, String departure_time,
			int total_seats, int available_seats, int ticket_price) {
		super();
		this.name = name;
		this.bus_no = bus_no;
		this.type = type;
		this.route = route;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.total_seats = total_seats;
		this.available_seats = available_seats;
		this.ticket_price = ticket_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBus_no() {
		return bus_no;
	}

	public void setBus_no(String bus_no) {
		this.bus_no = bus_no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String time) {
		this.arrival_time = time;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public int getTotal_seats() {
		return total_seats;
	}

	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}

	public int getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}

	public int getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(int ticket_price) {
		this.ticket_price = ticket_price;
	}

	@Override
	public String toString() {
		return "Bus [name=" + name + ", bus_no=" + bus_no + ", type=" + type + ", route=" + route + ", arrival_time="
				+ arrival_time + ", departure_time=" + departure_time + ", total_seats=" + total_seats
				+ ", available_seats=" + available_seats + ", ticket_price=" + ticket_price + "]";
	}
	
	
}
