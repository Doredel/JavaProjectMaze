package boot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

		try {
			//creating the Database
			connection = DriverManager.getConnection("jdbc:mysql://localhost", "root", "1234");
			stmt = connection.createStatement();
		    stmt.executeUpdate("CREATE DATABASE MAZE3D;");
		    
		    //creating the table in the maze3d database
		    connection = DriverManager.getConnection("jdbc:mysql://localhost/maze3d", "root", "1234");
			stmt = connection.createStatement();
		    stmt.executeUpdate("CREATE TABLE MAZECACHE(NAME varchar(20),MAZE blob,SOLUTION blob);");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Creation compleated");
	}
}
