package com.example.BookMyShowdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movieInfo")
	
public class MovieInfo {
	
		@Id
		@GeneratedValue
		private int movieInfoid;
		
		private String movieNumber;
		
		private String movieType;
		
		private int numberofSeats;
		
		@ManyToOne
		@JoinTable(name = "moviesInfo", joinColumns = {
		@JoinColumn(name = "movieInfoid", referencedColumnName = "movieInfoid") }, inverseJoinColumns = {
		@JoinColumn(name = "theatreId", referencedColumnName = "theatreId") })
		private TheatreInfo theatreInfo;
		
		public MovieInfo() {
			
		}

		public MovieInfo(String movieNumber, String movieType, int numberofSeats, TheatreInfo theatreInfo) {
			super();
			this.movieNumber = movieNumber;
			this.movieType = movieType;
			this.numberofSeats = numberofSeats;
			this.theatreInfo = theatreInfo;
		}

		public int getMovieInfoid() {
			return movieInfoid;
		}

		public void setMovieInfoid(int movieInfoid) {
			this.movieInfoid = movieInfoid;
		}

		public String getMovieNumber() {
			return movieNumber;
		}

		public void setMovieNumber(String movieNumber) {
			this.movieNumber = movieNumber;
		}

		public String getMovieType() {
			return movieType;
		}

		public void setMovieType(String movieType) {
			this.movieType = movieType;
		}

		public int getNumberofSeats() {
			return numberofSeats;
		}

		public void setNumberofSeats(int numberofSeats) {
			this.numberofSeats = numberofSeats;
		}

		public TheatreInfo getTheatreInfo() {
			return theatreInfo;
		}

		public void setTheatreInfo(TheatreInfo theatreInfo) {
			this.theatreInfo = theatreInfo;
		}

		@Override
		public String toString() {
			return "MovieInfo [movieInfoid=" + movieInfoid + ", movieNumber=" + movieNumber + ", movieType=" + movieType
					+ ", numberofSeats=" + numberofSeats + ", theatreInfo=" + theatreInfo + "]";
		}
		


}
