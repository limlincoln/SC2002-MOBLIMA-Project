package initializer;

import java.nio.file.Path;
import java.nio.file.Paths;

// TODO: Auto-generated Javadoc
/**
 * The Class GetDatabaseDirectory.
 */
public class GetDatabaseDirectory implements IGetCurrentDirectory{

	/** The Constant DBfolder. */
	public static final String DBfolder = "/Database/";
	
	/**
	 * Gets the current directory.
	 *
	 * @return the current directory
	 */
	@Override
	public String getCurrentDirectory() {
		Path executionPath = Paths.get(System.getProperty("user.dir"));

		return executionPath.getParent().getParent().toString() + DBfolder;
	}

}
