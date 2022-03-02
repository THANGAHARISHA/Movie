package com.example.BookMyShowdemo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "bookingRecord")
public class BookingRecord implements Serializable {
	
	
		
		private static final long serialVersionUID = -3103984818331012750L;

		@Id
		@GeneratedValue
		private int bookingId;

		private LocalDateTime bookingDate;

		private String movieName;

		private double amount;

		private LocalDate movieDate;

		private String movieNumber;

		private LocalTime movieTime;

		private String place;

		private String status;
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinTable(name="bookingDetails", joinColumns = {@JoinColumn(name="bookingId")} , inverseJoinColumns = {@JoinColumn(name="memberId")})
		private List<Member> members;
		
		public BookingRecord() {
			
		}

		public BookingRecord(LocalDateTime bookingDate, String movieName, double amount, LocalDate movieDate,
				String movieNumber, LocalTime movieTime, String place, String status, List<Member> members) {
			super();
			this.bookingDate = bookingDate;
			this.movieName = movieName;
			this.amount = amount;
			this.movieDate = movieDate;
			this.movieNumber = movieNumber;
			this.movieTime = movieTime;
			this.place = place;
			this.status = status;
			this.members = members;
		}

		public int getBookingId() {
			return bookingId;
		}

		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}

		public LocalDateTime getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(LocalDateTime bookingDate) {
			this.bookingDate = bookingDate;
		}

		public String getMovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<Member> getMembers() {
			return members;
		}

		public void setMembers(List<Member> members) {
			this.members = members;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "BookingRecord [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", movieName=" + movieName
					+ ", amount=" + amount + ", movieDate=" + movieDate + ", movieNumber=" + movieNumber
					+ ", movieTime=" + movieTime + ", place=" + place + ", status=" + status + ", members=" + members
					+ "]";
		}

		
}
