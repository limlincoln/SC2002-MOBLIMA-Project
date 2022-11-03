package managers;

public class LoginManager {
    private static LoginManager single_instance = null;

    private LoginManager(){}


    public static LoginManager getInstance()
    {
        if (single_instance == null)
            single_instance = new LoginManager();
        return single_instance;
    }

    public boolean login(String username, String password){
        return true;
    }

}