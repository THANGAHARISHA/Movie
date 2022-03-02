package com.example.BookMyShowdemo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="amount")
public class Amount {
	

		
		@Id
		@GeneratedValue
		private int amountId;

		private String currency;
		
		private double amount;

		public Amount() {
			
		}

		
		public Amount(String currency, double amount) {
			super();
			this.currency = currency;
			this.amount = amount;
		}

		public int getAmountId() {
			return amountId;
		}

		public void setAmountId(int amountId) {
			this.amountId = amountId;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "amount [amountId=" + amountId + ", currency=" + currency + ", amount=" + amount + "]";
		}

		

		
}
