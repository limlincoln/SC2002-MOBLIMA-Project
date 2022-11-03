package entities;

/**
 * This is the StaffManager. For now it is a simple manager that will handle the login issues of staff
 *
 */
public class Staff {
	
	private Integer StaffId;
	private String StaffName;
	private Integer CineplexID;
	
	public Staff(int StaffId,String StaffName, int CineplexID) {
		this.StaffId = StaffId;
		this.StaffName = StaffName;
		this.CineplexID = CineplexID;
	}
	
}