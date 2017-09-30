package db_mini_projekt;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Registration {

	public Registration() {
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM registration");

			// 4. processera resultatet
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") +" "+resultSet.getString("student_id") +" "+ resultSet.getString("faculty_id") +" "+ resultSet.getString("start_date") );
				System.out.println();
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.print("select '1' to delete a registration");
		Scanner chooseCommand = new Scanner(System.in);
		int commandNumber = chooseCommand.nextInt();
		deleteReg();
		chooseCommand.close();

	}

public void deleteReg() {
		
		System.out.print("Please insert a registration id to delete: ");
		Scanner temp1 = new Scanner(System.in);
		int registrationId = temp1.nextInt();

		Properties mySQLProps1 = new Properties();
		mySQLProps1.setProperty("user", "root");
		mySQLProps1.setProperty("password", "");
		String URL1 = "jdbc:mysql://localhost:3306/db_mini_projekt";
		temp1.close();
		try {
			//1 h�mta anslutning
				Connection connection = DriverManager.getConnection(URL1, mySQLProps1);
			
			//2 skapa ett statement
				Statement statement = connection.createStatement();
			
			//3 k�ra SQL fr�ngan och h�mta resultat
				statement.executeUpdate("DELETE FROM registration where id= " + registrationId);

					
			//4 Procesera resultatet 
		}
			catch(SQLException e) {
				e.printStackTrace();
			}

	}
}