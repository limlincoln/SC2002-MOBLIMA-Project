package entities;

/**
 * Class that contains information about a Staff
 *
 */
public class Staff {
	/**
	 * The ID of this Staff
	 */
	private Integer StaffId;

	/**
	 * the name of this Staff
	 */
	private String StaffName;

	/**
	 * the Cineplex ID to which this Staff has been assigned
	 */
	private Integer CineplexID;
	
	/**
	 * Constructor for the Staff Class
	 * @param StaffId the id of this staff
	 * @param StaffName the name of this staff
	 * @param CineplexID the cinplex id to which this staff has been assigned
	 */
	public Staff(int StaffId,String StaffName, int CineplexID) {
		this.StaffId = StaffId;
		this.StaffName = StaffName;
		this.CineplexID = CineplexID;
	}
	
	// GETTERS and SETTERS
	public Integer getStaffId() {
		return this.StaffId;
	}

	public void setStaffId(Integer StaffId) {
		this.StaffId = StaffId;
	}

	public String getStaffName() {
		return this.StaffName;
	}

	public void setStaffName(String StaffName) {
		this.StaffName = StaffName;
	}

	public Integer getCineplexID() {
		return this.CineplexID;
	}

	public void setCineplexID(Integer CineplexID) {
		this.CineplexID = CineplexID;
	}

}