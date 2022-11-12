package entities;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer.
 */
public class Customer{

	/** the ID assigned to this Customer. */
	private Integer customerID;

	/** the userName of this Customer. */
	private String userName;

	/** the email of this Customer. */
	private String email;

	/** the phoneNumber of this Customer. */
    private String phoneNumber;

	/**
	 * The Constructor for the Customer Class.
	 *
	 * @param customerID  the ID assigned to this Customer
	 * @param userName    the userName of this Customer
	 * @param email       the email of this Customer
	 * @param phoneNumber the phoneNumber of this Customer
	 */
	public Customer(int customerID, String userName, String email, String phoneNumber){
		this.customerID = customerID;
		this.userName= userName;
    	this.email= email;
    	this.phoneNumber= phoneNumber;
    }

	/**
	 * Gets the customer ID.
	 *
	 * @return the customer ID
	 */
	// GETTERS & SETTERS
	public Integer getCustomerID() {
		return customerID;
	}

	/**
	 * Sets the customer ID.
	 *
	 * @param customerID the new customer ID
	 */
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	} 

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}