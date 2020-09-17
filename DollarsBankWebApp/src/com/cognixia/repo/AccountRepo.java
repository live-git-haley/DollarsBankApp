package com.cognixia.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.model.Account;
import com.cognixia.model.Customer;

public class AccountRepo {
	int newCount;
	int count;
	public Account getAccount(String type, Long customerId) {
		Account newAccount = new Account();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("after class for name");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");

			System.out.println("Connected!");
		
			Statement statement = connection.createStatement();
			
			ResultSet account = statement.executeQuery("select * from accounts where customerId = " + customerId 
					+ " and accountType = '" + type + "'");

			while(account.next()) {

				newAccount.setCustomerId(customerId);
				newAccount.setType(type);
				newAccount.setAmount(account.getDouble("amount"));
				newAccount.setId(account.getLong("id"));
				
			}
			
			
			
			

			
			System.out.println("Got the account information!");
			
		
		
			statement.close();
			connection.close();
	


		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return(newAccount);

	}


}
