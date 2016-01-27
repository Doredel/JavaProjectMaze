package boot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.cfg.Configuration;

/**
 * this class creates the database
 * this must be activated before the server
 * @author Dor Edelstein, Lior Mantin
 *
 */
public class DatabaseConfig {
	public static void main(String [] args)
	{
		Connection connection;
		Statement stmt = null;
		
		Configuration config = new Configuration();
		config.configure();
		String username = config.getProperty("connection.username");
		String password = config.getProperty("connection.password");

		try {
			//creating the Database
			connection = DriverManager.getConnection("jdbc:mysql://localhost", username, password);
			stmt = connection.createStatement();
		    stmt.executeUpdate("CREATE DATABASE MAZE3D;");
		    
		    //creating the table in the maze3d database
		    connection = DriverManager.getConnection("jdbc:mysql://localhost/maze3d", username, password);
			stmt = connection.createStatement();
		    stmt.executeUpdate("CREATE TABLE MAZECACHE(NAME varchar(20),MAZE blob,SOLUTION blob);");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Creation compleated");
	}
}
