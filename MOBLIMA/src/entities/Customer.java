package entities;

/**
 * Class that contains information about a Customer (Movie-goer)
 */
public class Customer{

	/**
	 * the ID assigned to this Customer
	 */
	private Integer customerID;

	/**
	 * the userName of this Customer
	 */
	private String userName;

	/**
	 * the email of this Customer
	 */
	private String email;

	/**
	 * the phoneNumber of this Customer
	 */
    private String phoneNumber;

	/**
	 * The Constructor for the Customer Class
	 * @param customerID the ID assigned to this Customer
	 * @param userName the userName of this Customer
	 * @param email the email of this Customer 
	 * @param phoneNumber the phoneNumber of this Customer 
	 */
	public Customer(int customerID, String userName, String email, String phoneNumber){
		this.customerID = customerID;
		this.userName= userName;
    	this.email= email;
    	this.phoneNumber= phoneNumber;
    }

	// GETTERS & SETTERS
	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	} 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}