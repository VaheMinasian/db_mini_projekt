package db_mini_projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Registration {
		Properties mySQLProps = new Properties();
		String URL = "jdbc:mysql://localhost:3306/db_mini_projekt";
		int result = 0;
		public Registration() {
		mySQLProps.setProperty("user", "root");
		mySQLProps.setProperty("password", "");		

		try {
			// 1. kopla ut mot databsen
			Connection connection = DriverManager.getConnection(URL, mySQLProps);

			// 2. skapa ett statement
			Statement statement = connection.createStatement();

			// 3. kor SQL fraga och hämta ner resultatet
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
		deleteReg();
	}

public void deleteReg() {
		
		System.out.print("Please insert a registration id to delete: ");
		Scanner temp1 = new Scanner(System.in);
		while (!temp1.hasNextInt()){
			System.out.print("invalid input! Please enter a number");
			temp1.next();
		}
		int registrationId = temp1.nextInt();

		try {
			//1 hamta anslutning
				Connection connection = DriverManager.getConnection(URL, mySQLProps);
			
			//2 skapa ett statement
				Statement statement = connection.createStatement();
			
			//3 kora SQL frangan och hamta resultat
				result = statement.executeUpdate("DELETE FROM registration where id= " + registrationId);
				 	
			//4 Procesera resultatet
				if (result!=0)
		        	System.out.println("row with id number "+ registrationId +" deleted successfully.");
		        else if (result==0)
		        	System.out.println("no changes made to the table.");	    
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
	}
}