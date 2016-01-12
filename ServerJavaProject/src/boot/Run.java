package boot;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import presenter.ServerProperties;

public class Run {
	
	public static void main(String[] args) {
		ServerProperties serverProperties = new ServerProperties();
		
		serverProperties.setPort(1202);
		serverProperties.setNumThreads(3);
		serverProperties.setInterfaceType("CLI");
		
		try {
			XMLEncoder xmle = new XMLEncoder(new FileOutputStream("ServerProperties.xml"));
			xmle.writeObject(serverProperties);
			xmle.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
