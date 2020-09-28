package com.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import com.dto.CancelBooking;
import com.dto.Movie;
import com.dto.Movie1;
import com.dto.Theatre;
import com.dto.Ticket;

public class CancelBookingDAO {
	
	public int cancelTicket(int ticketId, int customerId, int count){
		
		CancelBooking cancelBooking = new CancelBooking();
		Ticket ticket = new Ticket();
		TicketDAO ticketDAO = new TicketDAO();
		ticket = ticketDAO.getTicket(ticketId);
		if(ticket != null){
		
		Movie movie = new Movie();
		/*MovieDAO movieDAO = new MovieDAO();
		movie = movieDAO.getMovie(ticket.getMovie().getMovieId());*/				
		//cancelBooking.setCurrentDate(LocalDate.now(ZoneId.systemDefault()));
		//cancelBooking.setCurrentTime(LocalTime.now(ZoneId.systemDefault()));
		
		//Date date = cancelBooking.getCurrentDate();
		
		/*DateFormat formatter = new SimpleDateFormat("dd-mm-yyy"); 
		Date today = Calendar.getInstance().getTime(); 

	    String strDate = formatter.format(date);*/
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
	    Date dateobj = new Date();
	    cancelBooking.setCurrentDate(df.format(dateobj));
	    
	    System.out.println(cancelBooking.getCurrentDate());
	    System.out.println(ticket.getMovie().getMovieDate());
	    
	    /*LocalTime time = cancelBooking.getCurrentTime();
	    
	    formatter= new SimpleDateFormat("hh:mm:ss"); 
	    String strTime = formatter.format(time);*/
	    if(((cancelBooking.getCurrentDate()).compareTo(ticket.getMovie().getMovieDate()) < 0) && ((ticket.getCustomer().getCustomerId() == customerId) && (count > 0))){
	    	
	    	System.out.println("Only 60% of amount will be refunded!!");
	    	
	    	cancelBooking.setCancelStatus(true);
	    	double temp = count*(360);
	    	cancelBooking.setRefund(temp);
	    	System.out.println(cancelBooking.getRefund());
	    	
	    	movie.setSeatsRemaining(movie.getSeatsRemaining()+count);
	    	emailSending emailsending = new emailSending();
	 	    emailsending.sendCancelDetailsEmail(ticketId, count, cancelBooking);
	    	//movieDAO.editMovie(movie1); 	    	
	     }
	     return 1;
		}
	    
	    else{
	    	System.out.println("Not possible..");
	    	cancelBooking.setCancelStatus(false);
	    	cancelBooking.setRefund(0);
	    	return 0;
	    }
	    
	    
	}

}
