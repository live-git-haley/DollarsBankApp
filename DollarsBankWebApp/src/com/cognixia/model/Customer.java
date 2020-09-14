package com.cognixia.model;

public class Customer {
	
	private int id;
	private static int count = 1;
	private String firstName;
	private String lastName;
	private String dob;
	private String email;
	private String password;
	private double amount;
	
	
	public Customer(String firstName, String lastName, String dob, String email, String password,
			double amount) {
		super();
		this.id = count++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.amount = amount;
	}
	

	public Customer() {
		this.id = count++;
		this.firstName = "NA";
		this.lastName = "NA";
		this.dob = "01/01/1990";
		this.amount = 0.0;
		this.email ="NA";
		this.password = "NA";
	}


	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", email=" + email + ", password=" + password + ", amount=" + amount + "]";
	}



	
	
	
}
