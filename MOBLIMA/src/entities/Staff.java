package entities;

/**
 * This is the StaffManager. For now it is a simple manager that will handle the login issues of staff
 *
 */
public class Staff {
	/**
	 * 
	 */
	private Integer StaffId;
	private String StaffName;
	private Integer CineplexID;
	
	public Staff(int StaffId,String StaffName, int CineplexID) {
		this.StaffId = StaffId;
		this.StaffName = StaffName;
		this.CineplexID = CineplexID;
	}
	

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