package db_mini_projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Db_main {

	public static void main(String[]args) {
		
		System.out.print("select table\n'1' for student |");
		System.out.print(" '2' for subject  |");
		System.out.print(" '3' for faculty |");
		System.out.print(" '4' for belongsto_has |");
		System.out.println(" '5' for registration |\n");
		Scanner chooseTable = new Scanner(System.in);
		int tableName = chooseTable.nextInt();
		chooseTable(tableName);
		
		
		/*
			//0. Anslutningsinformation
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
				ResultSet resultSet = statement.executeQuery("Select start_date from registration");
					
			//4 Procesera resultatet
			while(resultSet.next()) {
				System.out.println(resultSet.getString("start_date"));
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}*/
	}
	public static void chooseTable(int i) {
		switch (i) {
		
		case 1: Student student = new Student();
		break;	
		
		case 2: Registration reg = new Registration();
		break;	
		/*
		case 3: Faculty faculty = new Faculty();
		break;	
		
		case 4: BelongsToHas link = new BelongsToHas();
		break;	
		
		case 5: Subject subject = new Subject();
		break;	
		*/
		default:
		break;
		
		}
	}
}
