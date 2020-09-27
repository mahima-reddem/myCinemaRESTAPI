package com.ts;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.CancelBookingDAO;
import com.dao.CustomerDAO;
import com.dao.MovieDAO;
import com.dao.PaymentDAO;
import com.dao.TheatreDAO;
import com.dao.TicketDAO;
import com.dao.emailSending;
import com.dto.CancelBooking;
import com.dto.Customer;
import com.dto.Customer1;
import com.dto.Movie;
import com.dto.Movie1;
import com.dto.Payment;
import com.dto.Theatre;
import com.dto.Ticket;
import com.dto.Ticket1;

@Path("myresource")
public class MyResource {

   
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("Hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHi() {
        return "Hi Resource!";
    }
    
    @Path("registerCustomer1")
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    public String registerCustomer1(){
    	Customer customer = new Customer();
    	customer.setCustomerId(1);
    	customer.setCustName("Harsha");
    	customer.setCustMobileno("9700251531");
    	customer.setCustEmail("sreeharsha.1210@gmail.com");
   
    	
    	CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.register(customer);
		System.out.println("Customer Registeredd!!");
		return "Success";
    	
    }
    
    
    @Path("registerCustomer")
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    public Customer registerCustomer(Customer customer){
    	CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.register(customer);
		System.out.println("Customer added!!");
		return customer;
    	
    }
    
    
    @Path("registerTicket")
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    public Ticket registerTicket(Ticket1 ticket1){
    	System.out.println("Ticket choosed : " + ticket1.getMovie().getMovieId());
        	
    	Customer customer = new Customer();
    	customer.setCustomerId(ticket1.getCustomer().getCustomerId());
    	customer.setCustName(ticket1.getCustomer().getCustName());
    	customer.setCustEmail(ticket1.getCustomer().getCustEmail());
    	customer.setCustMobileno(ticket1.getCustomer().getCustMobileno());
    	
    	Movie movie = new Movie();
    	MovieDAO movieDAO = new MovieDAO();
    	movie = movieDAO.getMovie(ticket1.getMovie().getMovieId());
    	//movie.setMovieId(ticket1.getMovie().getMovieId());
    	
    	Ticket ticket = new Ticket();
    	ticket.setNoofTickets(ticket1.getNoofTickets());
    	ticket.setTicketId(ticket1.getTicketId()); 
    	ticket.setCustomer(customer); 
    	ticket.setMovie(movie);
    	 
    	TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.register(ticket);
		System.out.println("This is ticket :" + ticket);
		return ticket;
    	
    }

    
	
	@Path("registerTheatre")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Theatre registerTheatre(Theatre theatre){
		System.out.println("Theatre added!! " + theatre);
    	TheatreDAO theatreDAO = new TheatreDAO();
		theatreDAO.register(theatre);
		//System.out.println("Theatre added!!");
		return theatre;
	
    }
    	
	
	@Path("registerMovie")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Movie registerMovie(Movie1 movie1){
		System.out.println(movie1);
		
		
		Theatre theatre = new Theatre();
		theatre.setTheatreId(movie1.getTheatre().getTheatreId());
		
		Movie movie = new Movie();
		movie.setMovieId(movie1.getMovieId());
		movie.setMovieDate(movie1.getMovieDate());
		movie.setMovieName(movie1.getMovieName());
		movie.setMovieRating(movie1.getMovieRating());
		movie.setMovieTime(movie1.getMovieTime());
		movie.setSeatsRemaining(movie1.getSeatsRemaining());
		movie.setTheatre(theatre);
		
		MovieDAO movieDAO = new MovieDAO();
		movieDAO.register(movie);
		
		return movie;
	}
	
	
	
	@Path("getAllCustomers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomers(){
		System.out.println("In get all customers");
		List<Customer> customers = new ArrayList<Customer>();
		CustomerDAO customerDAO = new CustomerDAO();
		customers = customerDAO.getAllCustomers();
		System.out.println(customers);
		return customers;
	}
	
	
	@Path("getAllTickets")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> getAllTickets(){
		System.out.println("In get all tickets");
		List<Ticket> tickets = new ArrayList<Ticket>();
		TicketDAO ticketDAO = new TicketDAO();
		tickets = ticketDAO.getAllTickets();
		//System.out.println(tickets);
		return tickets;
	}
	
	@Path("getAllTheatres")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Theatre> getAllTheatres(){
		List<Theatre> theatres = new ArrayList<Theatre>();
		TheatreDAO theatreDAO = new TheatreDAO();
		theatres = theatreDAO.getAllTheatres();
		return theatres;
	}
	
	@Path("getAllMovies")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAllMovies(){
		List<Movie> movies = new ArrayList<Movie>();
		MovieDAO movieDAO = new MovieDAO();
		movies = movieDAO.getAllMovies();
		return movies;
	}
	
	@Path("getCustomer/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("id") int id){
		Customer customer = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		customer = customerDAO.getCustomer(id);
		return customer;
	}
	
	@Path("getCustomerByMobileNo/{details}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerByMobileNo(@PathParam("details") String details){
		String phone,password;
		String words[];
		words = details.split(" ");
		phone = words[0];
		password = words[1];
		Customer customer = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		customer = customerDAO.getCustomerByMobileNo(phone, password);
		return customer;
		
		
	}
	
	
	@Path("getTicket/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket getTicket(@PathParam("id") int id){
		Ticket ticket = new Ticket();
		TicketDAO ticketDAO = new TicketDAO();
		ticket = ticketDAO.getTicket(id);
		return ticket;
		
	}
	
	@Path("getMovie/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public Movie getMovie(@PathParam("id") int id){
		Movie movie = new Movie();
		MovieDAO movieDAO = new MovieDAO();
		movie = movieDAO.getMovie(id);
		return movie;
	}
	
	@Path("getTicketsByCustomerId/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> getTicketsByCustomerId(@PathParam("id") int id){
		System.out.println("CustomerId :" + id);
		List<Ticket> tickets = new ArrayList<Ticket>();
		TicketDAO ticketDAO = new TicketDAO();
		tickets = ticketDAO.getTicketsByCustomerId(id);
		return tickets;
	
	}
	
	@Path("getMoviesByTheatreId/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMoviesByTheatreId(@PathParam("id") int id){
		System.out.println(id);
		List<Movie> movies = new ArrayList<Movie>();
		MovieDAO movieDAO = new MovieDAO();
		movies = movieDAO.getMoviesByTheatreId(id);
		return movies;
	}
	
	@Path("updateTheatre")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void updateTheatre(Theatre theatre){
		TheatreDAO theatreDAO = new TheatreDAO();
		theatreDAO.editTheatre(theatre);
		
	}
	
	@Path("updateCustomer")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public int updateCustomer(Customer customer){
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.editCustomer(customer);
		System.out.println("Customer details updated in database");
		return 0;
	}
	
	@Path("updateMovie")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public int updateMovie(Ticket1 ticket){
		System.out.println("Update movie:" + ticket.getMovie());
		//TicketDAO ticketDAO = new TicketDAO();
		Movie1 movie = new Movie1();
		MovieDAO movieDAO = new MovieDAO();
		
		movie = ticket.getMovie();
		movieDAO.editMovie(movie);
		System.out.println("Movie details updated in database");
		return 0 ;
	}
	
	@Path("updateTicket")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public int updateTicket(Ticket1 ticket){
		System.out.println("Update ticket:" + ticket);
		TicketDAO ticketDAO = new TicketDAO();
		ticketDAO.editTicket(ticket);
		System.out.println("Ticket details updated in database");
		return 0;
		
	}
	
	
	@Path("confirmBooking/{ticketId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String confirmBooking(@PathParam("ticketId") int ticketId){
		Ticket ticket = new Ticket();
		TicketDAO ticketDAO = new TicketDAO();
		
		Customer customer = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		
		Movie movie = new Movie();
		MovieDAO movieDAO = new MovieDAO();
		
		Theatre theatre = new Theatre();
		TheatreDAO theatreDAO = new TheatreDAO();
		
		ticket = ticketDAO.getTicket(ticketId);
		customer = customerDAO.getCustomer(ticket.getCustomer().getCustomerId());
		movie = movieDAO.getMovie(ticket.getMovie().getMovieId());
		theatre = theatreDAO.getTheatre(movie.getTheatre().getTheatreId());
		
		emailSending emailsending = new emailSending();
		emailsending.sendEmail(customer, ticket, theatre, movie);
		
		return "Your Booking is successful";
	}
	
	
	/*@Path("confirmCustomer/{details}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int bookTicket(@PathParam("details") String details){
		int ticketId,otp;
		String words[];
		words = details.split(" ");
		
		ticketId = Integer.parseInt(words[0]);
		otp = Integer.parseInt(words[1]);
		//System.out.println(ticketId);
		//System.out.println(otp);
		
		Ticket ticket = new Ticket();
		TicketDAO ticketDAO = new TicketDAO();
		ticket = ticketDAO.getTicket(ticketId);
		System.out.println(ticket);
		
		Customer customer = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		customer = customerDAO.getCustomer(ticket.getCustomer().getCustomerId());
		customer.setOtp(otp);
		customerDAO.editCustomer(customer);		
		
		Movie1 movie = new Movie1();
		MovieDAO movieDAO = new MovieDAO();
		movie = movieDAO.getMovie(ticket.getMovie().getMovieId());
		movie.setSeatsRemaining(movie.getSeatsRemaining() - ticket.getNoofTickets());
		movieDAO.editMovie(movie);
		
		System.out.println("Your ticket is freezed!!");
		return 0;
		
		
	}*/
	
	@Path("generateOTP/{ticketId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int generateOTP(@PathParam("ticketId") int ticketId){
		Ticket ticket = new Ticket();
		TicketDAO ticketDAO = new TicketDAO();
		ticket = ticketDAO.getTicket(ticketId);
		
		Customer customer = new Customer();
		CustomerDAO customerDAO = new CustomerDAO();
		customer = customerDAO.getCustomer(ticket.getCustomer().getCustomerId());
		
		emailSending emailsending = new emailSending();
		int otp = emailsending.generateOtp(customer);
		return otp;
		
	}
	
	
	@Path("confirmPayment/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Payment confirmPayment(@PathParam("id") int id){
		Ticket ticket = new Ticket();
		TicketDAO ticketDAO = new TicketDAO();
		ticket = ticketDAO.getTicket(id);
		System.out.println("Ticket:" + ticket);
		System.out.println("Payment");
		Payment payment = new Payment();
		PaymentDAO paymentDAO = new PaymentDAO();
		payment = paymentDAO.paymentConfirmation(ticket);
		System.out.println("Payment : "+ payment);
		return payment;
	}
	
	@Path("cancelTicketBooking/{details}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int cancelTicketBooking(@PathParam("details") String details){
		int count,ticketId;
		String words[];
		words = details.split(" ");
		
		ticketId = Integer.parseInt(words[0]);
		count = Integer.parseInt(words[1]);
		System.out.println("TicketId :"+ticketId);
		System.out.println("Count : "+count);
		//CancelBooking cancelBooking = new CancelBooking();
		CancelBookingDAO cancelBookingDAO = new CancelBookingDAO();
	    int result = cancelBookingDAO.cancelTicket(ticketId, count);
	   
	    return result;
	  
		
	}
	
	
    
    
}
