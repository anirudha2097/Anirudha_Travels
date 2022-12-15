package com.masai.model;

public class BookingHistory {

	private String busNo;
	private String route;
	private int seats;
	private int ticketPrice;
	
	public BookingHistory() {
		// TODO Auto-generated constructor stub
	}

	public BookingHistory(String busNo, String route, int seats, int ticketPrice) {
		super();
		this.busNo = busNo;
		this.route = route;
		this.seats = seats;
		this.ticketPrice = ticketPrice;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
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
		return "BookingHistory [busNo=" + busNo + ", route=" + route + ", seats=" + seats + ", ticketPrice="
				+ ticketPrice + "]";
	}

	
	
}
