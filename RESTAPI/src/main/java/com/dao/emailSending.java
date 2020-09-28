package com.dao;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dto.CancelBooking;
import com.dto.Customer;
import com.dto.Movie;
import com.dto.Theatre;
import com.dto.Ticket;

public class emailSending {
	
	public int generateOtp(Customer customer){
		int randomPin = (int)(Math.random()*9000)+1000;
		String otp = String.valueOf(randomPin);
		
		final String username = "bookingtickets2020@gmail.com";
		final String password = "bookingtickets";
		
		String sendMessage = "Hi "+ customer.getCustName() + "!\nHere is the OTP : " + otp + "for the confirmation of your booking. ";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
	      
	      Session sessionobj = Session.getInstance(prop,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

	      try {
		   
		   Message message = new MimeMessage(sessionobj);
		   message.setFrom(new InternetAddress("bookingtickets2020@gmail.com"));
           message.setRecipients(
                   Message.RecipientType.TO,
                   InternetAddress.parse(customer.getCustEmail())
           );
           message.setSubject("OTP mail.. ");
           message.setText(sendMessage);
		   Transport.send(message);
		   
		   System.out.println("Your email sent successfully....");
	      } 
	      catch (MessagingException e) {
	         e.printStackTrace();
	      }
	      return Integer.parseInt(otp);
	}
	
	public void sendEmail(Customer customer,Ticket ticket, Theatre theatre, Movie movie){
		
		System.out.println("Mail Sending...");
		
		final String username = "bookingtickets2020@gmail.com";
		final String password = "bookingtickets";
		
		String setMessage = "Hi " + customer.getCustName() + "!\nYour tickets are booked!!\nDetails are:\n"
				+ "\nTicket Id : " + ticket.getTicketId() + "\n" +
				"\nTheatre Name :" + theatre.getTheatreName() + "\n" +
				"Theatre Address :" + theatre.getTheatreAddress() + "\n" +
				"Movie Name : " + movie.getMovieName() + "\n" +
				"Movie Date: " + movie.getMovieDate() + "\n" +
				"Movie Timings : " + movie.getMovieTime() + "\n" +
				"No.of Tickets Booked : " + ticket.getNoofTickets() + "\n" +
				"Total amount : " + 600*ticket.getNoofTickets() + "\n" +
				"Have a nice day:)\n\nThank you for choosing myCinema.";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
	      
	      Session sessionobj = Session.getInstance(prop,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

	      try {
		   
		   Message message = new MimeMessage(sessionobj);
		   message.setFrom(new InternetAddress("bookingtickets2020@gmail.com"));
           message.setRecipients(
                   Message.RecipientType.TO,
                   InternetAddress.parse(customer.getCustEmail())
           );
           message.setSubject("Booking Successful");
           message.setText(setMessage);
		   Transport.send(message);
		   
		   System.out.println("Your email sent successfully....");
	      } 
	      catch (MessagingException e) {
	         e.printStackTrace();
	      }
	}
	
	public void sendCancelDetailsEmail(int ticketId, int count, CancelBooking cancelBooking){
		System.out.println("Cancel details sending...");
		Ticket ticket = new Ticket();
		TicketDAO ticketDAO = new TicketDAO();
		ticket = ticketDAO.getTicket(ticketId);
		
		final String username = "bookingtickets2020@gmail.com";
		final String password = "bookingtickets";
		
		String setMessage = "Hi " + ticket.getCustomer().getCustName() + "!\nYour Booking Details are:\n"
				+"\nTicket ID : " + ticket.getTicketId() + "\n" +
				 "\nTheatre Name :" + ticket.getMovie().getTheatre().getTheatreName() + "\n" +
				"Theatre Address :" + ticket.getMovie().getTheatre().getTheatreAddress() + "\n" +
				"Movie Name : " + ticket.getMovie().getMovieName() + "\n" +
				"Movie Date: " + ticket.getMovie().getMovieDate() + "\n" +
				"Movie Timings : " + ticket.getMovie().getMovieTime() + "\n" +
				"No.of Tickets Booked : " + ticket.getNoofTickets() + "\n" +
				"Total amount Paid: " + 600*ticket.getNoofTickets() + "\n\n\n\n" +
				"Cancel Booking details:\n\n" +
				"Only 60% per ticket will be refunded..\n"+
				"No.of Tickets cancelled : " + count + "\n" +
				"No.of Tickets available : " + (ticket.getNoofTickets()-count) + "\n" +
				"Refund amount : " + cancelBooking.getRefund() + "\n" +
				"Have a nice day:)\n\nThank you for choosing myCinema.";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
	      
	      Session sessionobj = Session.getInstance(prop,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

	      try {
		   
		   Message message = new MimeMessage(sessionobj);
		   message.setFrom(new InternetAddress("bookingtickets2020@gmail.com"));
           message.setRecipients(
                   Message.RecipientType.TO,
                   InternetAddress.parse(ticket.getCustomer().getCustEmail())
           );
           message.setSubject("Cancel Booking");
           message.setText(setMessage);
		   Transport.send(message);
		   
		   System.out.println("Cancel details sent to email successfully....");
	      } 
	      catch (MessagingException e) {
	         e.printStackTrace();
	      }
		
	}


}
