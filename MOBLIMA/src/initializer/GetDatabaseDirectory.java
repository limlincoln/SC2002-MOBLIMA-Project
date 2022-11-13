package initializer;

import java.io.File;
import java.nio.file.Paths;

import utils.CheckOSHelper;

public class GetDatabaseDirectory{
	public static final String separator = File.separator;
	public static final String DBfolder = "Database";
	
	/** 
	 * @return finalpath - return a directory
	 * 
	 * current directory has a path appended to it
	 */
	public static String getCurrentDirectory() {
		String executionPath = "";
		if(CheckOSHelper.IS_MAC){
			executionPath = Paths.get(System.getProperty("user.dir")).getParent().getParent().toString();
		}else{
			executionPath = Paths.get(System.getProperty("user.dir")).toString();
		}

		String finalPath = executionPath + separator + DBfolder + separator;

		return finalPath;
	}
}
