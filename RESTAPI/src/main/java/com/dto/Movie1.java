package com.dto;

import java.util.ArrayList;
import java.util.List;

public class Movie1 {

	private int movieId;
	private String movieName;
	private int movieRating;
	private String movieDate;
	private String movieTime;
	private int seatsRemaining;
	
	private List<Ticket1> tickets=new ArrayList<Ticket1>();
	
	private Theatre1 theatre;	
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}
	
	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public int getSeatsRemaining() {
		return seatsRemaining;
	}

	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}

	public Theatre1 getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre1 theatre) {
		this.theatre = theatre;
	}

	public List<Ticket1> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket1> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Movie1 [movieId=" + movieId + ", movieName=" + movieName + ", movieRating=" + movieRating
				+ ", movieDate=" + movieDate + ", movieTime=" + movieTime + ", seatsRemaining=" + seatsRemaining
				+ ", tickets=" + tickets + ", theatre=" + theatre + "]";
	}

	
}
