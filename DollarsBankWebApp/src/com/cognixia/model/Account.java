package com.cognixia.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

	private Long id;
	private Long customerId;
	private double amount;
	private String type;
	
	public Account(Long id, Long customerId, double amount, String type) {
		super();
		this.id =  (long) atomicInteger.incrementAndGet();
		this.customerId = customerId;
		this.amount = amount;
		this.type = type;
	}
	
	public Account() {
		this.id =  (long) atomicInteger.incrementAndGet();
		this.customerId = -1L;
		this.amount = 0.0;
		this.type = "NA";
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", customerId=" + customerId + ", amount=" + amount + ", type=" + type + "]";
	}
	
	
	
	
}
