package managers;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginManager.
 */
public class LoginManager {
    
    /** The single instance. */
    private static LoginManager single_instance = null;

    /**
	 * Instantiates a new login manager.
	 */
    private LoginManager(){}


    /**
	 * Gets the single instance of LoginManager.
	 *
	 * @return single instance of LoginManager
	 */
    public static LoginManager getInstance()
    {
        if (single_instance == null)
            single_instance = new LoginManager();
        return single_instance;
    }

    /**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 */
    public boolean login(String username, String password){
        return true;
    }

}