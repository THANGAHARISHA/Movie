package com.example.BookMyShowdemo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="movie")

public class Movie {
	
		
		@Id
		@GeneratedValue
		private int id;	

		private String movieName;

		private String duration;
		
		private LocalDate movieDate;
		
		private String movieNumber;
		
		private LocalTime movieTime; 

		private String place;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "amountId")
		private Amount amount;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="movieInfoid")
		private MovieInfo movieInfo;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="inventoryId")
		private Inventory inventory;

		public Movie() {
			
		}

		public Movie(String movieName, String duration, LocalDate movieDate, String movieNumber, LocalTime movieTime,
				String place, Amount amount, MovieInfo movieInfo, Inventory inventory) {
			super();
			this.movieName = movieName;
			this.duration = duration;
			this.movieDate = movieDate;
			this.movieNumber = movieNumber;
			this.movieTime = movieTime;
			this.place = place;
			this.amount = amount;
			this.movieInfo = movieInfo;
			this.inventory = inventory;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public LocalDate getMovieDate() {
			return movieDate;
		}

		public void setMovieDate(LocalDate movieDate) {
			this.movieDate = movieDate;
		}

		public String getMovieNumber() {
			return movieNumber;
		}

		public void setMovieNumber(String movieNumber) {
			this.movieNumber = movieNumber;
		}

		public LocalTime getMovieTime() {
			return movieTime;
		}

		public void setMovieTime(LocalTime movieTime) {
			this.movieTime = movieTime;
		}

		public String getPlace() {
			return place;
		}

		public void setPlace(String place) {
			this.place = place;
		}

		public Amount getAmount() {
			return amount;
		}

		public void setAmount(Amount amount) {
			this.amount = amount;
		}

		public MovieInfo getMovieInfo() {
			return movieInfo;
		}

		public void setMovieInfo(MovieInfo movieInfo) {
			this.movieInfo = movieInfo;
		}

		public Inventory getInventory() {
			return inventory;
		}

		public void setInventory(Inventory inventory) {
			this.inventory = inventory;
		}

		@Override
		public String toString() {
			return "Movie [id=" + id + ", movieName=" + movieName + ", duration=" + duration + ", movieDate="
					+ movieDate + ", movieNumber=" + movieNumber + ", movieTime=" + movieTime + ", place=" + place
					+ ", amount=" + amount + ", movieInfo=" + movieInfo + ", inventory=" + inventory + "]";
		}

		
}
