package com.cognixia.model;

public class Account {
	
	private int id;
	private int customerId;
	private double amount;
	public Account(int id, int customerId, double amount) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
