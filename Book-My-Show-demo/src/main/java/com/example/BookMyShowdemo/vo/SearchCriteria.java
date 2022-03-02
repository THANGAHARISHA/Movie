package com.example.BookMyShowdemo.vo;

import java.util.Date;

public class SearchCriteria {
	
private String place;
	
	private String movieName;
	
	private Date movieDate;
	
	private int count;
	public SearchCriteria(String place, String movieName, Date movieDate, int count) {
		super();
		this.place = place;
		this.movieName = movieName;
		this.movieDate = movieDate;
		this.count = count;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SearchCriteria [place=" + place + ", movieName=" + movieName + ", movieDate=" + movieDate + ", count="
				+ count + "]";
	}

	
	
	
	

}
