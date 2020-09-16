package com.cognixia.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.model.Customer;

public class AccountRepo {
	int newCount;
	int count;
	public void newCustomer(Customer customer) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("after class for name");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");

			System.out.println("Connected!");
		

			Statement statement = connection.createStatement();
			
			ResultSet max = statement.executeQuery("select max(id) as 'maxValue' from customer");
			while(max.next()) {
				count = max.getInt("maxValue");
				
			}
		
			newCount = count+1;

			statement.executeUpdate("insert into customer values("
					+ newCount + " , '"
					+ customer.getFirstName() + "', '"
					+ customer.getLastName() + "', '" 
					+ customer.getDob() + "' , '"
					+ customer.getEmail() + "' , '"
					+ customer.getPassword() + "' , "
					+ customer.getAmount() + ")");

			System.out.println("Success added into DB");
			
		
		
			statement.close();
			connection.close();



		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		

	}


}
