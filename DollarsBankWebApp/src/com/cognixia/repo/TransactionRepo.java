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
	
	
	public double makeTransaction(Long id, double amount, String action) {
		double newAmount = 0.0;
		

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("after class for name");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");

			System.out.println("Connected!");

			Statement statement = connection.createStatement();

			ResultSet currAmount = statement.executeQuery("select amount from Customer where id = " + id);
			double amt = 0;
			while (currAmount.next()) {

				amt = currAmount.getDouble("amount");
				System.out.println(amt);
			}
		
			if(action.equals("withdraw")) {
				newAmount = amt- amount;
			}
			else {
				newAmount = amt+ amount;
			}
				
			System.out.println("new Amount "+newAmount);
			ResultSet max = statement.executeQuery("select max(id) as 'maxValue' from transactions");
			while(max.next()) {
				count = max.getInt("maxValue");
				
			}
		
			newCount = count+1;
			System.out.println("ID IN REPO>>>> " + id);
			statement.executeUpdate("UPDATE customer SET amount = " + newAmount + " WHERE id = " + id);
			if(amount!= 0.0) {
			statement.executeUpdate("insert into transactions values("+newCount+", " + id + ", '"+action + "'," + amount + ", '1/1/2020')");
			}
			connection.close();
			currAmount.close();
			statement.close();
		

//		| ClassNotFoundException

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return(newAmount);
	}
	
	public List<Transactions> getTransactionsById(Long id) {
		List<Transactions> list = new ArrayList(); 

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("after class for name");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");

			System.out.println("Connected!");

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
