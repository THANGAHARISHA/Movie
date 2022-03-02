package com.example.BookMyShowdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "checkin")
	
public class Checkin {
	
		@Id
		@GeneratedValue
		private int checkinId;
		
		private String seatNumber;
		
		private String TicketNumber;

		public int getCheckinId() {
			return checkinId;
		}
		

		public Checkin() {

		}


		public Checkin(String seatNumber, String ticketNumber) {
			super();
			this.seatNumber = seatNumber;
			TicketNumber = ticketNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public void setSeatNumber(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getTicketNumber() {
			return TicketNumber;
		}

		public void setTicketNumber(String ticketNumber) {
			TicketNumber = ticketNumber;
		}

		public void setCheckinId(int checkinId) {
			this.checkinId = checkinId;
		}

		@Override
		public String toString() {
			return "Checkin [checkinId=" + checkinId + ", seatNumber=" + seatNumber + ", TicketNumber=" + TicketNumber
					+ "]";
		}
		

}
