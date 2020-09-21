package com.cognixia.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.connection.ConnectionClass;
import com.cognixia.model.Transactions;

public class TransactionRepo {
	int count;
	int newCount;
	String transAccount;
	
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connect = connectionClass.makeConnection();
	
	
	
	public double makeTransaction(Long id, double amount, String action, String accountType) {
		double newAmount = 0.0;
		try {

			
			Statement statement = connect.createStatement();

			ResultSet currAmount = statement.executeQuery("select amount from accounts WHERE customerId = " + id + " And accountType = '"  
										+ accountType +  "'");
			
			currAmount.next();
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
				
				amount2.next();
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
			currAmount.close();
			statement.close();
			max.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return(newAmount);
	}
	
	public List<Transactions> getTransactionsById(Long id) {
		List<Transactions> list = new ArrayList(); 

		try {

			Statement statement = connect.createStatement();

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
		
			transactions.close();
			statement.close();
		



		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return(list);
	}
	
	

}
