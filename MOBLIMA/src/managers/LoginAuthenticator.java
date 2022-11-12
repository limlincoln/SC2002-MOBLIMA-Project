package managers;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import initializer.GetDatabaseDirectory;

public class LoginAuthenticator extends GetDatabaseDirectory{

    private static LoginAuthenticator single_instance = null;


    public static LoginAuthenticator getInstance()
    {
        if (single_instance == null)
            single_instance = new LoginAuthenticator();
        return single_instance;
    }	
	
    

    private LoginAuthenticator() {
    	
    }
	
    
    /**
	 * Login authenticator to test for correct login credentials
	 * @param username
	 * @param password
	 * @return
	 */
    public boolean login(String username, String password) {
        try {

			String root = LoginAuthenticator.getCurrentDirectory();

	    	String filepath =  root+"staff_table.txt";
	        BufferedReader br = new BufferedReader(new FileReader(filepath));
	        

	        String line;
	        while((line = br.readLine()) != null) {
	            String[] values = line.split("\\|");
	            
	            if (values[0].equals(username) && values[1].equals(password)) {
	            	   System.out.println("Access Granted!");
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
    
    //Logout
    public boolean logout(){
        return false;
    }
}
