import java.util.ArrayList;
import java.util.List;


public class Customer{

	private Integer CustomerID;
	

	private String Name;
	

	private String Email;

    private Integer PhoneNumber;


    private List<String> Booking = new ArrayList<String>();



	public Customer(int CustomerID, String Name, String Email, int PhoneNumber){
		this.CustomerID = CustomerID;
		this.Name= Name;
    	this.Email= Email;
    	this.PhoneNumber= PhoneNumber;
    	
    }


}