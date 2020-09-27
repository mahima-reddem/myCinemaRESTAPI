package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.db.HibernateTemplate;
import com.dto.Movie;
import com.dto.Movie1;
import com.dto.Theatre;

public class MovieDAO {
	
private SessionFactory factory = null;
	
	public int register(Movie movie){ 
		return HibernateTemplate.addObject(movie);
	}
	public Movie getMovie(int movieId) {
		return (Movie)HibernateTemplate.getObject(Movie.class,movieId);
	}
	public int editMovie(Movie1 movie1) {
		Movie movie = new Movie();
		movie.setMovieId(movie1.getMovieId());
		movie.setMovieName(movie1.getMovieName());
		movie.setMovieDate(movie1.getMovieDate());
		movie.setMovieTime(movie1.getMovieTime());
		movie.setMovieRating(movie1.getMovieRating());
		movie.setSeatsRemaining(movie1.getSeatsRemaining());
				
		Theatre theatre = new Theatre();
		theatre.setTheatreId(movie1.getTheatre().getTheatreId());
		theatre.setTheatreName(movie1.getTheatre().getTheatreName());
		theatre.setTheatreAddress(movie1.getTheatre().getTheatreAddress());
		
		movie.setTheatre(theatre);
		return HibernateTemplate.updateObject(movie);
	}
    public int deleteMovie(int id) {
    	return HibernateTemplate.deleteObject(Movie.class,id);
	}
    public List<Movie> getAllMovies() {
		List<Movie> movies=(List)HibernateTemplate.getObjectListByQuery("From Movie");
		System.out.println("Inside All Movies ..."+movies);
		return movies;	
	}
    
    public List<Movie> getMoviesByTheatreId(int theatreId){
    	List<Movie> movies = (List)HibernateTemplate.getMoviesByTheatreId(theatreId);
    	System.out.println("Movies by theatre Id..."+movies);
    	return movies;
    }



}
