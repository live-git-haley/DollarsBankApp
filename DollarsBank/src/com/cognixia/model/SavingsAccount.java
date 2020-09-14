package com.cognixia.model;

public class SavingsAccount {
	
	private int id;
	private int customerId;
	private int accountId;
	private double amount;
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
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public SavingsAccount(int id, int customerId, int accountId, double amount) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.accountId = accountId;
		this.amount = amount;
	}

}
