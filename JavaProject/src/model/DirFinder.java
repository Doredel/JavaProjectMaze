package model;

import java.io.File;

public class DirFinder {
	public static String FindDir(String path)
	{
		String files = "";
		try{
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
	
			for (File file : listOfFiles) {
				files += file.toString();
			}
		}
		catch(NullPointerException e){
			files = "there is no \""+path+"\"";
		}
		
		return files;
	}
}
