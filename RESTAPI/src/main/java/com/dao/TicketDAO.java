package com.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;

import com.db.HibernateTemplate;
import com.dto.Customer;
import com.dto.Movie;
import com.dto.Theatre;
import com.dto.Ticket;
import com.dto.Ticket1;

public class TicketDAO {
	
private SessionFactory factory = null;
	
	/*public Ticket getCustomerByName(String custName, String custPassword){
		return (Customer)HibernateTemplate.getObjectByName(custName, custPassword);
	}*/
    
	
	public int register(Ticket ticket) {		
		return HibernateTemplate.addObject(ticket);
	}
	
	public Ticket getTicket(int id) {
		return (Ticket)HibernateTemplate.getObject(Ticket.class, id);
	} 
	
	public List<Ticket> getAllTickets(){
		List<Ticket> tickets = (List)HibernateTemplate.getObjectListByQuery("from Ticket");
		System.out.println("Inside All Tickets ..."+tickets);
		return tickets;
	}
	
	public List<Ticket> getTicketsByCustomerId(int id){
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets = (List)HibernateTemplate.getTicketsByCustomerId(id);
		System.out.println("Tickets by customerId :" +tickets);
		return tickets;
	}
	
	public int editTicket(Ticket1 ticket1){
		Ticket ticket = new Ticket();
		
		ticket.setTicketId(ticket1.getTicketId());
		ticket.setNoofTickets(ticket1.getNoofTickets());
		
		Customer customer = new Customer();
		customer.setCustomerId(ticket1.getCustomer().getCustomerId());
		customer.setCustName(ticket1.getCustomer().getCustName());;
		customer.setCustEmail(ticket1.getCustomer().getCustEmail());
		customer.setCustMobileno(ticket1.getCustomer().getCustMobileno());
		customer.setOtp(ticket1.getCustomer().getOtp());
		customer.setPassword(ticket1.getCustomer().getPassword());
		
		ticket.setCustomer(customer);
		
		Movie movie = new Movie();
		movie.setMovieId(ticket1.getMovie().getMovieId());
		movie.setMovieName(ticket1.getMovie().getMovieName());
		movie.setMovieDate(ticket1.getMovie().getMovieDate());
		movie.setMovieTime(ticket1.getMovie().getMovieTime());
		movie.setMovieRating(ticket1.getMovie().getMovieRating());
		movie.setSeatsRemaining(ticket1.getMovie().getSeatsRemaining());
		
		Theatre theatre = new Theatre();
		theatre.setTheatreId(ticket1.getMovie().getTheatre().getTheatreId());
		theatre.setTheatreName(ticket1.getMovie().getTheatre().getTheatreName());
		theatre.setTheatreAddress(ticket1.getMovie().getTheatre().getTheatreAddress());
		movie.setTheatre(theatre);
		
		ticket.setMovie(movie);
		
		return HibernateTemplate.updateObject(ticket);
	}
	
	public int deleteTicket(int ticketId){
		return HibernateTemplate.deleteObject(Ticket.class, ticketId);
	}


}
