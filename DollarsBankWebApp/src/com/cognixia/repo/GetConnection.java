package com.cognixia.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	
	GetConnection() {

	}

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
					"haleykobe2");
			System.out.println("Connected!");

				
			return (connection);
		

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return null;

	}

}
