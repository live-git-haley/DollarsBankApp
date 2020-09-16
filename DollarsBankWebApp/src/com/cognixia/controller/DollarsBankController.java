package com.cognixia.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.cognixia.model.Customer;
import com.cognixia.model.Transactions;

public class DollarsBankController {
	
	
	
	public Customer createAccount() {
		
		Scanner input = new Scanner(System.in);

		
		System.out.println("******** Create New Account ********");
		System.out.println("First Name: ");
		String firstName = input.nextLine();
		
		System.out.println("Last Name: ");
		String lastName = input.nextLine();
		
		
		System.out.println("Date of Birth (mm/dd/yyyy) : ");
		String dob = input.nextLine();
		
		
		System.out.println("Email: ");
		String email = input.nextLine();
		
		System.out.println("Password: ");
		String password = input.nextLine();
		
		System.out.println("Initial $$ Amount: ");
		double amount = input.nextDouble();
		
		Customer c1 = new Customer(1L, firstName, lastName, dob, email, password, amount);
		
		input.close();
		
		return(c1);
	}
	
	public Customer login(List<Customer> customerList, String email, String password) {
		

		Boolean valid = false;
		
		for(int i = 0; i <= customerList.size()-1; i++) {
			if(email.contentEquals(customerList.get(i).getEmail()) && password.contentEquals(customerList.get(i).getPassword())) {
				System.out.println("Valid...");
				valid = true;
				return(customerList.get(i));
			}

		}
		
		if(valid == false) {
			System.out.println("Customer not found...");
		}
		
	
		return new Customer();
		
	}
	
	
	
	
	
	
//	
//	public void deposit(double amt, Customer currentCustomer, List<Transactions> transactions) {
//		
//	
//		currentCustomer.setAmount(currentCustomer.getAmount()+amt);
//		Transactions transaction = new Transactions(currentCustomer.getId(), "Deposit", amt, "1/1/2020");
//		transactions.add(transaction);
//		
//		
//		
//	}
//	
//	public void withdraw(double amt, Customer currentCustomer, List<Transactions> transactions) {
//		
//	
//		
//		currentCustomer.setAmount(currentCustomer.getAmount()-amt);
//		
//		Transactions transaction = new Transactions(currentCustomer.getId(), "Withdraw", amt, "1/1/2020");
//		transactions.add(transaction);
//		
//		
//		
//	}
	
	
//	public static void main(String[] args) {
//		DepositRepo repo = new DepositRepo();
//		repo.makeDeposit(3L, 25.0);
//	}
	
	
	

}
