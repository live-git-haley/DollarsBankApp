package com.cognixia.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.connection.ConnectionClass;
import com.cognixia.model.Account;
import com.cognixia.model.Customer;

public class AccountRepo {
	int newCount;
	int count;
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connect = connectionClass.makeConnection();
	
	public Account getAccount(String type, Long customerId) {
		Account newAccount = new Account();

		try {

			Statement statement = connect.createStatement();
			ResultSet account = statement.executeQuery("select * from accounts where customerId = " + customerId 
					+ " and accountType = '" + type + "'");

			while(account.next()) {

				newAccount.setCustomerId(customerId);
				newAccount.setType(type);
				newAccount.setAmount(account.getDouble("amount"));
				newAccount.setId(account.getLong("id"));
				
			}

			statement.close();
			account.close();
	


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return(newAccount);

	}


}
