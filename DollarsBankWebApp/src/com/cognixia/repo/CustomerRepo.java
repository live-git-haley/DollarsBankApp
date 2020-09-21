package com.cognixia.repo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.cognixia.connection.ConnectionClass;
import com.cognixia.model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepo {

	
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connect = connectionClass.makeConnection();
	
	

	public List<Customer> getCustomers() {

		List<Customer> customerList = new ArrayList<Customer>();
		List<Customer> emptyList = new ArrayList<Customer>();

		
		
		try {

			Statement statement = connect.createStatement();
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
			
				customerList.add(customer);

			}
			customers.close();
			statement.close();

			return (customerList);
		
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		

		return(emptyList);
		}



	public void newCustomer(Customer customer) {
		
		try {
			
			Statement statement = connect.createStatement();
			statement.executeUpdate("insert into customer values("
					+ 0L + " , '"
					+ customer.getFirstName() + "', '"
					+ customer.getLastName() + "', '" 
					+ customer.getDob() + "' , '"
					+ customer.getEmail() + "' , '"
					+ customer.getPassword() + "' , "
					+ customer.getinitialAmount() + ")");
			
			Long customerId = getCustomerId(customer.getEmail(), customer.getPassword());
			statement.executeUpdate("insert into accounts values (" + 0L + ", " + customerId+ ", 'checking', " + customer.getinitialAmount() + ")");
			statement.executeUpdate("insert into accounts values(" + 0L + "," + customerId + ", 'saving', 0.0)");

			statement.close();
		
		


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		

	}
	
	public static Long getCustomerId(String email, String password) {
		Long foundId;
		try {
						
			Statement statement = connect.createStatement();
			
			ResultSet found = statement.executeQuery("select id from customer where email = '" + email + "' AND password = '" + password + "'");
	
			found.next();
			
			foundId = found.getLong("id");
			statement.close();
		
			found.close();
			return(foundId);
			
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
	return(-1L);
		
	}
	
	
	public  Customer getCustomerById(Long id) {
		Long foundId;
		Customer customer = new Customer();
		try {
						
			Statement statement = connect.createStatement();
			
			ResultSet found = statement.executeQuery("select * from customer where id = " + id);
	
			found.next();
			
			customer.setId(found.getLong("id"));
			customer.setFirstName(found.getString("firstName"));
			customer.setLastName(found.getString("lastName"));
			customer.setDob(found.getString("dob"));
			customer.setEmail(found.getString("email"));
			customer.setPassword(found.getString("password"));

			
			statement.close();
		
			found.close();
			return(customer);
			
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
	return(customer);
		
	}
	
	

	

}
