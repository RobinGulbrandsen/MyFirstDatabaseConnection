package no.app.view;

import java.sql.SQLException;
import java.util.ArrayList;

import no.app.controller.DatabaseHandler;
import no.app.model.Person;

public class Client {
	
	public static void main(String[] args) {
		DatabaseHandler db = new DatabaseHandler();
		try {
			//Show initial data
			printPeople(db);
			
			//Insert new person
			Person batman = new Person("Batman", "1234");
			db.newPerson(batman);
			
			//Show refreshed list
			printPeople(db);
			
			//Change Batmans password
			batman.setPassword("new password");
			db.updatePerson(batman);
			
			//Show refreshed
			printPeople(db);
			
			//Delete Batman
			db.deletePerson(batman);
			
			//Show refreshed
			printPeople(db);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void printPeople(DatabaseHandler db) throws SQLException {
		//Show it all
		ArrayList<Person> persons = db.getPersons();	
		
		for(Person p : persons) {
			System.out.println(p);
		}
		System.out.println();
	}
}
