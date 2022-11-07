package initializer;

public class GetDatabaseDirectory implements IGetCurrentDirectory{

	public static final String DBfolder = "\\Database\\";
	
	@Override
	public String getCurrentDirectory() {
		String executionPath = System.getProperty("user.dir");

		return (executionPath + DBfolder);
	}

}
