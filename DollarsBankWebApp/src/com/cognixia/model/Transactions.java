package com.cognixia.model;

import java.util.Date;

public class Transactions {
	
	private int id;
	private Long customerId;
	private String type;
	private double amount;
	private String date;
	
	
	public Transactions(int id, Long customerId, String type, double amount, String date) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Transactions [id=" + id + ", customerId=" + customerId + ", type=" + type + ", amount=" + amount
				+ ", date=" + date + "]";
	}

}
