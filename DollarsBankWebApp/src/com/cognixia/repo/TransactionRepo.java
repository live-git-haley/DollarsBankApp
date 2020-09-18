package com.cognixia.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.model.Transactions;

public class TransactionRepo {
	int count;
	int newCount;
	String transAccount;
	
	
	public double makeTransaction(Long id, double amount, String action, String accountType) {
		double newAmount = 0.0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");


			Statement statement = connection.createStatement();

			ResultSet currAmount = statement.executeQuery("select amount from accounts WHERE customerId = " + id + " And accountType = '"  
										+ accountType +  "'");
			
			System.out.println(currAmount.first());
			double amt = 0;
		

			amt = currAmount.getDouble("amount");
			if(amt < amount && action.equals("withdraw")) {
				return -1.0;
			}
			
			if(amt < amount && action.equals("transfer")) {
				return -1.0;
			}
			
			
			if(action.equals("transfer")) {
			
				if(accountType.equals("saving")) {
					transAccount = "checking"; 
				}
				else {
					transAccount = "saving";
				}
					
			}

	
			switch(action){
			
			case "withdraw":
				newAmount = amt- amount;
				break;
	
			case "deposit":
				newAmount = amt+ amount;
				break;
				
		
			}
			
			if(action.equals("transfer")) {
				
				newAmount = amt- amount;
				
				ResultSet amount2 = statement.executeQuery("select amount from accounts WHERE customerId = " + id + " And accountType = '"  
						+ transAccount +  "'");
				
				double amt2 = amount2.getDouble("amount");
				
				double newAmount2 = amount + amt2;
				
				statement.executeUpdate("UPDATE accounts SET amount = " + newAmount2 + " WHERE customerId = " + id + " And accountType = '"
						+ transAccount + "'");

				amount2.close();
				
			}
			

			ResultSet max = statement.executeQuery("select max(id) as 'maxValue' from transactions");
			while(max.next()) {
				count = max.getInt("maxValue");
				
			}
		
			newCount = count+1;
			
			
			statement.executeUpdate("UPDATE accounts SET amount = " + newAmount + " WHERE customerId = " + id + " And accountType = '"
					+ accountType + "'");
			if(amount!= 0.0) {
			statement.executeUpdate("insert into transactions values("
					+newCount
					+", " + id 
					+ ", '"+action 
					+ "'," + amount 
					+ ", '1/1/2020', '" 
					+ accountType + "')");
			}
			connection.close();
			currAmount.close();
			statement.close();
			max.close();
			

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return(newAmount);
	}
	
	public List<Transactions> getTransactionsById(Long id) {
		List<Transactions> list = new ArrayList(); 

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");


			Statement statement = connection.createStatement();

			ResultSet transactions = statement.executeQuery("select * from Transactions where customerId = " + id);
			double amt = 0;
			while (transactions.next()) {
				Transactions one = new Transactions();

				one.setId(transactions.getInt("id"));
				one.setCustomerId(transactions.getLong("customerId"));
				one.setType(transactions.getString("type"));
				one.setAmount(transactions.getDouble("amount"));
				one.setDate(transactions.getString("date"));
				
				list.add(one);


				
			}
		
			connection.close();
			transactions.close();
			statement.close();
		



		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return(list);
	}
	
	

}
