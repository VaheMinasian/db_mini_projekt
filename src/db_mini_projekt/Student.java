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
		Scanner sc = new Scanner(System.in);
		String temp ="";
		Properties mySQLProps= new Properties();
		String URL = "jdbc:mysql://localhost:3306/db_mini_projekt";	
		int result = 0;

	public String getScanner() {
		temp = sc.nextLine();
		return temp;
	}
	
	public Student() {
		mySQLProps.setProperty("user", "root");
		mySQLProps.setProperty("password", "");
			
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
			System.out.println("\nselect '1' to insert || select '2' to update");
			String commandNumber = getScanner();
			while ((!commandNumber.equals("1")) && (!commandNumber.equals("2"))) {
				System.out.print("invalid input! Please enter a number");
				commandNumber = getScanner();
			}
			
			if (commandNumber.equals("1")) 
				insertStudent();
			else if (commandNumber.equals("2"))
				updateStudent();
	}
	
	public void updateStudent() {
		System.out.println("Please insert student id: ");
		int studentId = Integer.parseInt(getScanner());
		
		System.out.println("Please insert email: ");
		String studentEmail = getScanner();
		String prep = "Update student SET email=? WHERE id=?";

		try {
		//1 h�mta anslutning
			Connection connection = DriverManager.getConnection(URL, mySQLProps);
		
		//2 skapa ett statement
			PreparedStatement preparedStatement = connection.prepareStatement(prep);
	        preparedStatement.setString(1, studentEmail);
	        preparedStatement.setInt(2, studentId);	
	        result = preparedStatement.executeUpdate();
	        if (result!=0)
	        	System.out.println("1 row in student updated successfully.");
	        else if (result==0)
	        	System.out.println("no changes made to the table.");	        	
	       
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public Boolean isValid(String s) {
        return s.matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}");
    }
	
	public void insertStudent() {
		System.out.println("Please insert name: ");
		String studentName = getScanner();
		String studentEmail ="";
		while (!isValid(studentEmail)) {
			System.out.println("Please insert a valid email: ");
			studentEmail = getScanner();
		}
		
		String prep = "Insert INTO student (student_name , email) values(?, ?)";
		try {
		//1 hamta anslutning
			Connection connection = DriverManager.getConnection(URL, mySQLProps);
		
		//2 skapa ett statement
			PreparedStatement preparedStatement = connection.prepareStatement(prep);
	        preparedStatement.setString(1, studentName);
	        preparedStatement.setString(2, studentEmail);	
	        
		//3 kora SQL frangan och hamta resultat
			result = preparedStatement.executeUpdate();
			if (result!=0)
	        	System.out.println("a new student added successfully.");
	        else if (result==0)
	        	System.out.println("no changes made to the 'student' table.");	       
			
		//4 Procesera resultatet
			//resultSet.next();
		//	System.out.println(resultSet.getString("student_name") + " " + resultSet.getString("email"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
	}
}