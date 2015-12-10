package controller;

import java.io.File;

public class DirCommand extends CommonCommand {
	
	@Override
	public void doCommand() {
		findDir(input);
	}

	public static void findDir(String path){
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			System.out.println(file);
		}
		
	}
}
