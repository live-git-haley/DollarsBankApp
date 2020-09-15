package com.cognixia.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.model.Customer;

public class DepositRepo {

	public void makeDeposit(Long id, double add) {

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
			
			double newAmount = amt+ add;
			System.out.println("new Amount "+newAmount);
			
			statement.executeUpdate("UPDATE customer SET amount = " + newAmount + " WHERE id = " + id);
			System.out.println("insert into transactions values(6, " + id + ", 'deposit'," + add + ", '1/1/2020')");
			/*
			 * statement.executeUpdate("insert into transactions values(1, " + id +
			 * " , 'deposit'," + add + ", '1/1/2020'");
			 */				

			currAmount.close();
			statement.close();

//		| ClassNotFoundException

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
