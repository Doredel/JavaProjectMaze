package boot;



import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.xml.XMLConstants;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import algorithms.mazeGenerators.Position;
import model.MyModel;
import presenter.Presenter;
import presenter.Properties;
import view.MyView;

public class Run {
	public static void main(String[] args) {
		
		/*MyView<Position> view = new MyView<Position>(); 
		MyModel model = new MyModel();
		
		Presenter<Position> presenter = new Presenter<Position>(model, view);
		model.addObserver(presenter);
		view.addObserver(presenter);
		
		view.start();*/
		
		
        try {
        	Properties pro = new Properties();
    		FileOutputStream fos = new FileOutputStream("properties.xml");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(pro);
	        fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 

		
	}
}
