package entities;

public class Customer{

	private Integer customerID;
	private String userName;
	private String email;
    private Integer phoneNumber;

	public Customer(int customerID, String userName, String email, int phoneNumber){
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

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}