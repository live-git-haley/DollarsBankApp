package com.cognixia.repo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.cognixia.model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepo {

	public List<Customer> getCustomers(String action, Long id) {
		System.out.println("Got into repo");

		List<Customer> customerList = new ArrayList<Customer>();
		List<Customer> oneCustomer = new ArrayList<Customer>();
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("after class for name");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");

			System.out.println("Connected!");

			Statement statement = connection.createStatement();

			ResultSet customers = statement.executeQuery("select * from Customer");
			System.out.println(customers);
			
			
		
			while (customers.next()) {
				Customer customer = new Customer();

				customer.setId(customers.getLong("id"));
				
				customer.setFirstName(customers.getString("firstName"));
				customer.setLastName(customers.getString("lastName"));
				customer.setEmail(customers.getString("email"));
				customer.setDob(customers.getString("dob"));
				customer.setPassword(customers.getString("password"));
				customer.setAmount(customers.getDouble("amount"));
				
				if(customers.getLong("id") == id){
					oneCustomer.add(customer);
				}
				customerList.add(customer);

			}
			
			System.out.println(oneCustomer.toString());
		
			customers.close();
			statement.close();
			connection.close();

//		| ClassNotFoundException

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		if(action.equals("getOne")) {
			return(oneCustomer);
		}
		else {

		return (customerList);
		}

	}

	

}
