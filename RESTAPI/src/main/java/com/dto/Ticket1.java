package com.dto;

public class Ticket1 {
	
	 private int ticketId;
	 private int noofTickets;
	 //private String seatNo;
	 
	 private Customer1 customer;
	 
	 private Movie1 movie;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
   
	public int getNoofTickets() {
		return noofTickets;
	}

	public void setNoofTickets(int noofTickets) {
		this.noofTickets = noofTickets;
	}

	/*public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
  */
	
	public Customer1 getCustomer() {
		return customer;
	}

	public void setCustomer(Customer1 customer) {
		this.customer = customer;
	}

	public Movie1 getMovie() {
		return movie;
	}

	public void setMovie(Movie1 movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Ticket1 [ticketId=" + ticketId + ", noofTickets=" + noofTickets + ", customer=" + customer + ", movie="
				+ movie + "]";
	}
	
	
}
