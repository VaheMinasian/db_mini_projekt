package db_mini_projekt;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

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

		System.out.print("select '1' to insert |");
		Scanner chooseCommand = new Scanner(System.in);
		int commandNumber = chooseCommand.nextInt();
		insertFaculty();
		chooseCommand.close();

	}

public void insertFaculty() {
		
		System.out.print("Please insert a faculty name: ");
		Scanner temp1 = new Scanner(System.in);
		String facultyName = temp1.nextLine();

		Properties mySQLProps1 = new Properties();
		mySQLProps1.setProperty("user", "root");
		mySQLProps1.setProperty("password", "");
		String URL1 = "jdbc:mysql://localhost:3306/db_mini_projekt";
		String prep = "Insert INTO faculty (faculty_name) values(?)";
		temp1.close();
		try {
			// 1 h�mta anslutning
			Connection connection = DriverManager.getConnection(URL1, mySQLProps1);

			// 2 skapa ett statement
			PreparedStatement preparedStatement = connection.prepareStatement(prep);
			preparedStatement.setString(1, facultyName);
			// 3 k�ra SQL fr�ngan och h�mta resultat
			preparedStatement.executeUpdate(prep);

			// 4 Procesera resultatet
			// resultSet.next();
			// System.out.println(resultSet.getString("student_name") + " " +
			// resultSet.getString("email"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
