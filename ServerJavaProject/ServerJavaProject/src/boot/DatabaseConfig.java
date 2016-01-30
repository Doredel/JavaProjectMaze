package boot;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		boolean exits = false;
		Configuration config = new Configuration();
		config.configure(new File("hibernate.cfg.xml"));
		String username = config.getProperty("connection.username");
		String password = config.getProperty("connection.password");

		try {
			//creating the Database
			connection = DriverManager.getConnection("jdbc:mysql://localhost", username, password);
			ResultSet resultSet = connection.getMetaData().getCatalogs();

		    while (resultSet.next()) {

		    	String databaseName = resultSet.getString(1);
		    	if(databaseName.equals("maze3d")){
		    		exits = true;
		        }
		    }
		    resultSet.close();
			if(!exits){
				stmt = connection.createStatement();
	    	    stmt.executeUpdate("CREATE DATABASE MAZE3D;");
			}
		    
		    //creating the table in the maze3d database
		    connection = DriverManager.getConnection("jdbc:mysql://localhost/maze3d", username, password);
		    resultSet = connection.getMetaData().getTables(null, null, "%", null);
		    exits = false;
		    
		    while (resultSet.next()) {

		    	String tableName = resultSet.getString(3);
		    	if(tableName.equals("mazecache")){
		    		exits = true;
		        }
		    }
		    resultSet.close();
			if(!exits){
				stmt = connection.createStatement();
			    stmt.executeUpdate("CREATE TABLE MAZECACHE(NAME varchar(20),MAZE blob,SOLUTION blob ,PRIMARY KEY (NAME));");
			}
		    
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Creation compleated");
	}
}
