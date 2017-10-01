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
		Properties mySQLProps = new Properties();
		String URL = "jdbc:mysql://localhost:3306/db_mini_projekt";
		
	public Faculty() {
		mySQLProps.setProperty("user", "root");
		mySQLProps.setProperty("password", "");
		
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

		System.out.print("select '1' to insert:");
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			if(scanner.nextInt()==1)
				insertFaculty();
			else
				System.out.print("invalid input! Please enter '1' to insert faculty");
		}
		
	}

public void insertFaculty() {
		System.out.print("Please insert a faculty name: ");
		Scanner sc = new Scanner(System.in);
		String facultyName = sc.nextLine();
		sc.close();
		
		String prep = "Insert INTO faculty (faculty_name) values(?)";
		try {
			// 1 hamta anslutning
			Connection connection = DriverManager.getConnection(URL, mySQLProps);

			// 2 skapa ett statement
			PreparedStatement preparedStatement = connection.prepareStatement(prep);
			preparedStatement.setString(1, facultyName);
			// 3 kora SQL frangan och hamta resultat
			preparedStatement.executeUpdate();

			// 4 Procesera resultatet
			// resultSet.next();
			// System.out.println(resultSet.getString("student_name") + " " +
			// resultSet.getString("email"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}