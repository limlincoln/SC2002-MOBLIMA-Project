package Try;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.File;
//import java.util.Scanner;

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