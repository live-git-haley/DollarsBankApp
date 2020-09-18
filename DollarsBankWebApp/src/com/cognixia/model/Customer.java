package com.cognixia.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

	
	private Long id;
	private static Long count = 0L;
	private String firstName;
	private String lastName;
	private String dob;
	private String email;
	private String password;
	private double initialAmount;
	
	
	public Customer(Long id, String firstName, String lastName, String dob, String email, String password,
			double initialAmount) {
		super();
		this.id =  (long) atomicInteger.incrementAndGet();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.initialAmount = initialAmount;
	
	}
	

	public Customer() {
		this.id =  (long) atomicInteger.incrementAndGet();
		this.firstName = "NA";
		this.lastName = "NA";
		this.dob = "01/01/1990";
		this.initialAmount = 0.0;
		this.email ="NA";
		this.password = "NA";
	}


	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getinitialAmount() {
		return initialAmount;
	}


	public void setinitialAmount(double initialAmount) {
		this.initialAmount = initialAmount;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", email=" + email + ", password=" + password + ", initialAmount=" + initialAmount + "]";
	}



	
	
	
}
