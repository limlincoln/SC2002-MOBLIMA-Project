package entities;

// TODO: Auto-generated Javadoc
/**
 * This is the StaffManager. For now it is a simple manager that will handle the login issues of staff
 *
 */
public class Staff {
	
	/** The Staff id. */
	private Integer StaffId;
	
	/** The Staff name. */
	private String StaffName;
	
	/** The Cineplex ID. */
	private Integer CineplexID;
	
	/**
	 * Instantiates a new staff.
	 *
	 * @param StaffId    the staff id
	 * @param StaffName  the staff name
	 * @param CineplexID the cineplex ID
	 */
	public Staff(int StaffId,String StaffName, int CineplexID) {
		this.StaffId = StaffId;
		this.StaffName = StaffName;
		this.CineplexID = CineplexID;
	}
	
}