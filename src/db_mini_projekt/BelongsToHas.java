package db_mini_projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BelongsToHas {
	
	public BelongsToHas() {
		Properties mySQLProps = new Properties();
		mySQLProps.setProperty("user", "root");
		mySQLProps.setProperty("password", "");
		String URL = "jdbc:mysql://localhost:3306/db_mini_projekt";

		try {
			// 1. kopla ut mot databsen
			Connection connection = DriverManager.getConnection(URL, mySQLProps);

			// 2. skapa ett statement
			Statement statement = connection.createStatement();

			// 3. k�r SQL fr�ga och h�mta ner resultatet
			ResultSet resultSet = statement.executeQuery("SELECT * FROM belongsto_has");

			// 4. processera resultatet
			while (resultSet.next()) {
				System.out.println(resultSet.getString(" faculty_id") + " " + resultSet.getString("subject_id"));
				System.out.println();
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}