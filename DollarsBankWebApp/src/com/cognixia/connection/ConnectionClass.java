package com.cognixia.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionClass {
	
	private static Connection connection = null;

	public Connection makeConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		 Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarbank", "root",
						"haleykobe2");
		return(connection);
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return(connection);
	
	}

}

