package com.example.BookMyShowdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "member")
public class Member {
	
		
		@Id
		@GeneratedValue
		private int memberId;

		private String emailAddress;

		private String firstName;

		private String gender;

		private String lastName;

		private long mobileNumber;

		private int bookingId;
		
		@OneToOne(cascade =  CascadeType.ALL)
		@JoinColumn(name="checkinId")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
		private Checkin checkIn;
		
		public Member() {
			
		}

		public Member( String emailAddress, String firstName, String gender, String lastName,
				long mobileNumber, Checkin checkIn) {
			super();
			this.emailAddress = emailAddress;
			this.firstName = firstName;
			this.gender = gender;
			this.lastName = lastName;
			this.mobileNumber = mobileNumber;
			this.checkIn = checkIn;
		}

		public int getMemberId() {
			return memberId;
		}

		public void setMemberId(int memberId) {
			this.memberId = memberId;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public long getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public int getBookingId() {
			return bookingId;
		}

		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}

		public Checkin getCheckIn() {
			return checkIn;
		}

		public void setCheckIn(Checkin checkIn) {
			this.checkIn = checkIn;
		}

		@Override
		public String toString() {
			return "Member [memberId=" + memberId + ", emailAddress=" + emailAddress + ", firstName=" + firstName
					+ ", gender=" + gender + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber
					+ ", bookingId=" + bookingId + ", checkIn=" + checkIn + "]";
		}

				
		

}
