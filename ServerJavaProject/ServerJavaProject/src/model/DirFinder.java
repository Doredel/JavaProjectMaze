package model;

import java.io.File;

public class DirFinder {
	/**
	 * <strong>FindDir</strong>
	 * <p>
	 * <code>public static String FindDir(String path)</code>
	 * <p>
	 * The find dir method gives us all folders under the path parameter.
	 * 
	 * @param path The content of the dir that searched on.
	 * @return String The content of the dir that found.
	 */
	public static String FindDir(String path)
	{
		String files = "";
		try{
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
	
			for (File file : listOfFiles) {
				files += file.toString()+System.lineSeparator();
			}
		}
		catch(NullPointerException e){
			files = "there is no \""+path+"\""+System.lineSeparator();
		}
		
		return files;
	}
}
