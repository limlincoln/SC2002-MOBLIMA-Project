package initializer;

import java.nio.file.Path;
import java.nio.file.Paths;

// TODO: Auto-generated Javadoc
/**
 * The Class GetDatabaseDirectory.
 */
public class GetDatabaseDirectory implements IGetCurrentDirectory{

	/** The Constant DBfolder - stores the necessary text files */
	public static final String DBfolder = "\\Database\\";
	
	/**
	 * Gets the current directory.
	 *
	 * @return current/ 2 parent directory
	 */
	@Override
	public String getCurrentDirectory() {
		Path executionPath = Paths.get(System.getProperty("user.dir"));

		//return (executionPath + DBfolder);
		return executionPath.getParent().getParent().toString() + DBfolder;
	}

}
