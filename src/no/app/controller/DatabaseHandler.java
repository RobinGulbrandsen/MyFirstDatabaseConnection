package no.app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import no.app.model.Person;

public class DatabaseHandler {
	
	private Connection con;
	
	public DatabaseHandler() {
		DatabaseConnection dbc = new DatabaseConnection();
		try {
			con = dbc.getConnection();	
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	//CRUD Person
	public Person newPerson(Person p) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO person VALUE(?,?)");
		pstmt.setString(1, p.getUsername());
		pstmt.setString(2, p.getPassword());
		
		pstmt.executeUpdate();
		
		return p;
	}
	
	public ArrayList<Person> getPersons() throws SQLException {
		ArrayList<Person> persons = new ArrayList<Person>();
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM person");
		ResultSet result = pstmt.executeQuery();
		
		while(result.next()) {
			String name = result.getString(1);
			String password = result.getString(2);
			Person p = new Person(name, password);
			persons.add(p);
		}
		
		return persons;
	}
	
	public boolean updatePerson(Person p) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("UPDATE person SET password = ? WHERE username = ?");
		pstmt.setString(1, p.getPassword());
		pstmt.setString(2, p.getUsername());
		
		int rows = pstmt.executeUpdate();
		if(rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deletePerson(Person p) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM person WHERE username = ?");
		pstmt.setString(1, p.getUsername());
		
		int rows = pstmt.executeUpdate();
		if(rows > 0) {
			return true;
		}
		return false;
	}
}
