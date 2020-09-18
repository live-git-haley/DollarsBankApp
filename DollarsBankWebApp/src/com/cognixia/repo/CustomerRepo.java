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

	
	int newCount;
	int count;
	int count2;

	public List<Customer> getCustomers(String action, Long id) {

		List<Customer> customerList = new ArrayList<Customer>();
		List<Customer> oneCustomer = new ArrayList<Customer>();
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");


			Statement statement = connection.createStatement();
			ResultSet customers = statement.executeQuery("select * from Customer");

		
			while (customers.next()) {
				Customer customer = new Customer();

				customer.setId(customers.getLong("id"));
				customer.setFirstName(customers.getString("firstName"));
				customer.setLastName(customers.getString("lastName"));
				customer.setEmail(customers.getString("email"));
				customer.setDob(customers.getString("dob"));
				customer.setPassword(customers.getString("password"));
				customer.setinitialAmount(customers.getDouble("amount"));
				
				if(customers.getLong("id") == id){
					oneCustomer.add(customer);
				}
				customerList.add(customer);

			}
			
		
			customers.close();
			statement.close();
			connection.close();


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

	public void newCustomer(Customer customer) {
	
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");

			Statement statement = connection.createStatement();

			statement.executeUpdate("insert into customer values("
					+ customer.getId() + " , '"
					+ customer.getFirstName() + "', '"
					+ customer.getLastName() + "', '" 
					+ customer.getDob() + "' , '"
					+ customer.getEmail() + "' , '"
					+ customer.getPassword() + "' , "
					+ customer.getinitialAmount() + ")");
			
			
			statement.executeUpdate("insert into accounts values(" + customer.getId() + ", " + customer.getId()+ ", 'checking', " + customer.getinitialAmount() + ")");
			Long newID = customer.getId() +1L;
			statement.executeUpdate("insert into accounts values(" + newID + ", " + customer.getId() + ", 'saving', 0.0)");
			
		
		
			statement.close();
			connection.close();
		


		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

	

}
