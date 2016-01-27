package boot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConfig {
	public static void main(String [] args)
	{

		Connection connection;
		Statement stmt = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost", "root", "1234");
			stmt = connection.createStatement();
		    stmt.executeUpdate("CREATE DATABASE MAZE3D;");
		    
		    connection = DriverManager.getConnection("jdbc:mysql://localhost/maze3d", "root", "1234");
			stmt = connection.createStatement();
		    stmt.executeUpdate("CREATE TABLE MAZECACHE(NAME varchar(20),MAZE blob,SOLUTION blob);");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
