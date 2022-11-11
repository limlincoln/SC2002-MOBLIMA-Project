package initializer;

import java.nio.file.Path;
import java.nio.file.Paths;

public class GetDatabaseDirectory implements IGetCurrentDirectory{

	public static final String DBfolder = "/Database/";
	
	@Override
	public String getCurrentDirectory() {
		Path executionPath = Paths.get(System.getProperty("user.dir"));

		return executionPath.getParent().getParent().toString() + DBfolder;
	}

}
