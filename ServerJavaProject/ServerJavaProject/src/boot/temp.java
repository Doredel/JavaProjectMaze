package boot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import model.db.Cache;

public class temp {
	public static void main(String [] args)
	{

		
		MetadataSources metadata = new MetadataSources(new StandardServiceRegistryBuilder().applySetting("hibernate.dialect", "org.hibernate.dialect.H2Dialect").build());

			// [...] adding annotated classes to metadata here...
		metadata.addAnnotatedClass(Cache.class);

		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maze3d", "root", "1234");
			SchemaExport export = new SchemaExport((MetadataImplementor) metadata.buildMetadata(),connection);
			export.create(true, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
