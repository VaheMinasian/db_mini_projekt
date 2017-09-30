package db_mini_projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


public class Student {

	public Student() {
		
			Properties mySQLProps= new Properties();
			mySQLProps.setProperty("user", "root");
			mySQLProps.setProperty("password", "");
			String URL = "jdbc:mysql://localhost:3306/db_mini_projekt";	
			
			try {
			//1 h�mta anslutning
				Connection connection = DriverManager.getConnection(URL, mySQLProps);
			
			//2 skapa ett statement
				Statement statement = connection.createStatement();
			
			//3 k�ra SQL fr�ngan och h�mta resultat
				ResultSet resultSet = statement.executeQuery("Select * from student");
					
			//4 Procesera resultatet
			while(resultSet.next()) {
				System.out.println(resultSet.getString("student_name") + " " + resultSet.getString("email"));
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
			System.out.println("select '1' to insert ||");
			System.out.print(" select '2' to update");
			Scanner chooseCommand = new Scanner(System.in);
			int commandNumber = chooseCommand.nextInt();
			
			if (commandNumber == 1) 
				insertStudent();
			else if (commandNumber == 2)
				updateStudent();
			
			chooseCommand.close();
		
	}
	public void updateStudent() {
		System.out.println("Please insert student id: ");
		Scanner temp1 = new Scanner(System.in);
		int studentId = temp1.nextInt();
		System.out.println("Please insert email: ");
		Scanner temp2 = new Scanner(System.in);
		String studentEmail = temp2.nextLine();
		
		Properties mySQLProps2= new Properties();
		mySQLProps2.setProperty("user", "root");
		mySQLProps2.setProperty("password", "");
		String URL2 = "jdbc:mysql://localhost:3306/db_mini_projekt";	
		String prep = "Update student SET email=? WHERE id=?";
		temp1.close();
		temp2.close();

		try {
		//1 h�mta anslutning
			Connection connection = DriverManager.getConnection(URL2, mySQLProps2);
		
		//2 skapa ett statement
			Statement st = connection.createStatement();
			
			PreparedStatement preparedStatement = connection.prepareStatement(prep);
	        preparedStatement.setString(1, studentEmail);
	        preparedStatement.setInt(2, studentId);	
	        preparedStatement.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insertStudent() {
		System.out.println("Please insert name: ");
		Scanner temp1 = new Scanner(System.in);
		String studentName = temp1.nextLine();
		
		System.out.println("Please insert email: ");
		Scanner temp2 = new Scanner(System.in);
		String studentEmail = temp2.nextLine();
		
		Properties mySQLProps1= new Properties();
		mySQLProps1.setProperty("user", "root");
		mySQLProps1.setProperty("password", "");
		String URL1 = "jdbc:mysql://localhost:3306/db_mini_projekt";	
		String prep = "Insert INTO student (student_name , email) values(?, ?)";
		temp1.close();
		temp2.close();
		try {
		//1 h�mta anslutning
			Connection connection = DriverManager.getConnection(URL1, mySQLProps1);
		
		//2 skapa ett statement
			PreparedStatement preparedStatement = connection.prepareStatement(prep);
	        preparedStatement.setString(1, studentName);
	        preparedStatement.setString(2, studentEmail);	
	        
		//3 k�ra SQL fr�ngan och h�mta resultat
			preparedStatement.executeUpdate();
				
		//4 Procesera resultatet
			//resultSet.next();
		//	System.out.println(resultSet.getString("student_name") + " " + resultSet.getString("email"));

		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		
		
	}
}
