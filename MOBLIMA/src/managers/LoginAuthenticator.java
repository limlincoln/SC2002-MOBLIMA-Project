package managers;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginAuthenticator.
 */
public class LoginAuthenticator {

    /** The single instance. */
    private static LoginAuthenticator single_instance = null;


    /**
	 * Gets the single instance of LoginAuthenticator.
	 *
	 * @return single instance of LoginAuthenticator
	 */
    public static LoginAuthenticator getInstance()
    {
        if (single_instance == null)
            single_instance = new LoginAuthenticator();
        return single_instance;
    }	
	
    

    /**
	 * Instantiates a new login authenticator.
	 */
    private LoginAuthenticator() {
    	
    }
	
    
    /**
	 * Login authenticator to test for correct login credentials.
	 *
	 * @param username the username
	 * @param password the password
	 * 
	 * check if user is authorised for entry
	 * 
	 * @return true, if successful
	 */
    public boolean login(String username, String password) {
        try {
			String rootFolderName = "SC2002Assignment";	
			String projectRootPath;
			File file = new File(".");
			
			if (file.getCanonicalFile().getName().equals(rootFolderName) == true) {
				projectRootPath =  file.getCanonicalPath();
			} else {
				while (file.getName().equals(rootFolderName) != true) {
					file = file.getCanonicalFile().getParentFile();
				}
				
				projectRootPath = file.getCanonicalPath();
			}
	    	String filepath =  projectRootPath+"/staff_table.txt";
	        BufferedReader br = new BufferedReader(new FileReader(filepath));
	        

	        String line;
	        while((line = br.readLine()) != null) {
	            String[] values = line.split("\\|");
	            
	            if (values[0].equals(username) && values[1].equals(password)) {
	            	   System.out.println("Access Granted " + values[0]+ values[1]);
	                	br.close();
	                    return true;
	            }
	        }
	        br.close();
	        return false;
        } catch ( FileNotFoundException e ) {
			System.out.println( "Error opening the input file!" + e.getMessage() );
			System.exit( 0 );
		} catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
			e.printStackTrace();
			System.exit( 0 );
		}	
        
        return false;
    }
    
    /**
	 * Logout from MOBLIMA
	 *
	 * @return true, if successful
	 */
    //Logout
    public boolean logout(){
        return false;
    }
}
