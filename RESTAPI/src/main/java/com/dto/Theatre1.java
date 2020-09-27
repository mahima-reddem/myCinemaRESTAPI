package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Theatre1 {
	
	private int theatreId;
	private String theatreName;
	private String theatreAddress;

	private List<Movie1> movies =new ArrayList<Movie1>();
	
	public List<Movie1> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie1> movies) {
		this.movies = movies;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreAddress() {
		return theatreAddress;
	}

	public void setTheatreAddress(String theatreAddress) {
		this.theatreAddress = theatreAddress;
	}

	public List<Movie1> getMovieList() {
		return movies;
	}

	public void setMovieList(List<Movie1> movieList) {
		this.movies = movieList;
	}

	@Override
	public String toString() {
		return "Theatre1 [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreAddress="
				+ theatreAddress + ", movies=" + movies + "]";
	}
	
}
