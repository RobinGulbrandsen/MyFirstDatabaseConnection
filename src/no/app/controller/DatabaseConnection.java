package no.app.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	//Upate to match your needs
	private String databaseName = "test";
	private String username = "root";
	private String password = "";

	private Connection con;
	
	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		if(con != null) {
			return con;
		}
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, username, password);
		return con;
	}
	
}
