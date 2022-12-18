package com.masai.model;

public class BookingHistory {

	private String busName;
	private String route;
	private int seats;
	private int ticketPrice;
	
	public BookingHistory() {
		// TODO Auto-generated constructor stub
	}

	public BookingHistory(String busName, String route, int seats, int ticketPrice) {
		super();
		this.busName = busName;
		this.route = route;
		this.seats = seats;
		this.ticketPrice = ticketPrice;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "BookingHistory [busName=" + busName + ", route=" + route + ", seats=" + seats + ", ticketPrice="
				+ ticketPrice + "]";
	}

	
	
}
