package db_mini_projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Faculty {

	public Faculty() {
		Properties mySQLProps = new Properties();
		mySQLProps.setProperty("user", "root");
		mySQLProps.setProperty("password", "");
		String URL = "jdbc:mysql://localhost:3306/db_mini_projekt";

		try {
			// 1. kopla ut mot databsen
			Connection connection = DriverManager.getConnection(URL, mySQLProps);

			// 2. skapa ett statement
			Statement statement = connection.createStatement();

			// 3. kör SQL fråga och hämta ner resultatet
			ResultSet resultSet = statement.executeQuery("SELECT * FROM faculty");

			// 4. processera resultatet
			while (resultSet.next()) {
				System.out.println(resultSet.getString("faculty_name"));
				System.out.println();
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void insertNewFaculty(String facName) {
		Properties mySQLProps = new Properties();
		mySQLProps.setProperty("user", "root");
		mySQLProps.setProperty("password", "");
		String URL = "jdbc:mysql://localhost:3306/db_mini_projekt";

		try {
			// 1. kopla ut mot databsen
			Connection connection = DriverManager.getConnection(URL, mySQLProps);

			// 2. skapa ett statement
			Statement statement = connection.createStatement();

			// 3. kör SQL fråga och hämta ner resultatet
			ResultSet resultSet = statement.executeQuery("INSERT into faculty (faculty_name) VALUES "+ (facName));
			
			// 4. processera resultatet
			resultSet.next();
			System.out.println("faculty_name");

		
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
	}
	

