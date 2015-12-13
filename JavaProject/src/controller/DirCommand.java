package controller;

import view.View;
import model.Model;

public class DirCommand extends CommonCommand {
	
	public DirCommand(View v, Model m) {
		super(v, m);
	}

	@Override
	public void doCommand(String param) {
		//this.m.dir
	}
		/*try{
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
	
			for (File file : listOfFiles) {
				System.out.println(file);
			}
		}
		catch(NullPointerException e){
			System.out.println("there is no \""+path+"\"");
		}*/

}
