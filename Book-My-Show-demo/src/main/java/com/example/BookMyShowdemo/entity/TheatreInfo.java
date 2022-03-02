package com.example.BookMyShowdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="theatreInfo")
public class TheatreInfo {
	
		
		@Id
		@GeneratedValue
		private int theatreId;
		
		private String nameOfTheatre;

		public TheatreInfo() {
			super();
		}

		public TheatreInfo(int theatreId, String nameOfTheatre) {
			super();
			this.theatreId = theatreId;
			this.nameOfTheatre = nameOfTheatre;
		}

		public int getTheatreId() {
			return theatreId;
		}

		public void setTheatreId(int theatreId) {
			this.theatreId = theatreId;
		}

		public String getNameOfTheatre() {
			return nameOfTheatre;
		}

		public void setNameOfTheatre(String nameOfTheatre) {
			this.nameOfTheatre = nameOfTheatre;
		}

		@Override
		public String toString() {
			return "TheatreInfo [theatreId=" + theatreId + ", nameOfTheatre=" + nameOfTheatre + "]";
		}

		

}
