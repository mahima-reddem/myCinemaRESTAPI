package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@XmlRootElement
@Entity
@JsonIgnoreProperties(value={"customer", "movie"}, allowGetters=true)

public class Ticket {
	@Id
	@GeneratedValue
	 private int ticketId;
	 private int noofTickets;
	 //private String seatNo;
	 
	@JsonManagedReference
	 @ManyToOne
	 @JoinColumn(name = "customerId")
	 private Customer customer;
	 
	@JsonManagedReference
	 @ManyToOne
	 @JoinColumn(name = "movieId")
	 private Movie movie;

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
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
