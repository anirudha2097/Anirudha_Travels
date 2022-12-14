package com.masai.model;

public class BookingStatus {

	private String email;
	private int booked_seats;
	private boolean confirm_status;
	private String bus_no;
	
	public BookingStatus() {
		// TODO Auto-generated constructor stub
	}

	public BookingStatus(String email, int booked_seats, boolean confirm_status, String bus_no) {
		super();
		this.email = email;
		this.booked_seats = booked_seats;
		this.confirm_status = confirm_status;
		this.bus_no = bus_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBooked_seats() {
		return booked_seats;
	}

	public void setBooked_seats(int booked_seats) {
		this.booked_seats = booked_seats;
	}

	public boolean isConfirm_status() {
		return confirm_status;
	}

	public void setConfirm_status(boolean confirm_status) {
		this.confirm_status = confirm_status;
	}

	public String getBus_no() {
		return bus_no;
	}

	public void setBus_no(String bus_no) {
		this.bus_no = bus_no;
	}

	@Override
	public String toString() {
		return "BookingStatus [email=" + email + ", booked_seats=" + booked_seats + ", confirm_status=" + confirm_status
				+ ", bus_no=" + bus_no + "]";
	}
	
}
