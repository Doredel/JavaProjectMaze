package boot;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import presenter.Properties;

public class XMLMaker {
	
	public static void main(String[] args) throws Exception {

		Properties mb = new Properties();
		mb.setNumberOfThread(3);
		mb.setInterfaceType("CLI");

		FileOutputStream fos = new FileOutputStream("Properties.xml");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		XMLEncoder xmlEncoder = new XMLEncoder(bos);
		xmlEncoder.writeObject(mb);
		xmlEncoder.close();
			
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Properties.xml")));
		Properties properties = new Properties();
		properties = (Properties)decoder.readObject();
		System.out.println(properties.getNumberOfThread());
		System.out.println(properties.getInterfaceType());
		decoder.close();

	}
}
