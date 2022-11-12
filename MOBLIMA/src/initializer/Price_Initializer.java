package initializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import managers.PricingManager;

import java.util.*;
import java.io.*;

import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * The Class Price_Initializer.
 */
public class Price_Initializer extends GetDatabaseDirectory {
	
	/** The Constant DBfile. */
	public static final String DBfile = "Price_Matrix.txt";
	
	/** The hm. */
	HashMap<Object, Double> hm;
	
	/**
	 * Instantiates a new price initializer.
	 */
	public Price_Initializer(){
		
		hm = new HashMap<Object, Double>();
		
		hm.put("1", 9.8);
		hm.put("2", 7.4);
		hm.put("3", 5.9);
	}
	
	/**
	 * Creates the price matrix file.
	 */
	public static void CreatePriceMatrixFile() {
		
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		Price_Initializer price_init = new Price_Initializer();
		currentDirectory = price_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		File create_pricelisting_file = new File(newDirectory);
		
		try {
			if(!create_pricelisting_file.exists()) {
				create_pricelisting_file.mkdirs();
			}
			create_pricelisting_file = new File(newDirectory + DBfile);
			checkfileexists = create_pricelisting_file.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(create_pricelisting_file.getPath());
		
	}
	
	/**
	 * Write to price matrix.
	 *
	 * @param map the map
	 */
	public void WriteToPriceMatrix(HashMap<String, Double> map) {
		
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		Price_Initializer price_init = new Price_Initializer();
		currentDirectory = price_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		try {
			File pricematrix_file = new File(newDirectory);
			FileOutputStream fos = new FileOutputStream(pricematrix_file);
			PrintWriter printwriter = new PrintWriter(fos);
			
			//for(Map.Entry<Object, Double> hm:map.entrySet()) {
				//printwriter.println(hm.getKey() + "=" + hm.getValue());
			//}
			
			printwriter.flush();
			printwriter.close();
			fos.close();
		}
		catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Readfrom price matrix.
	 */
	public void ReadfromPriceMatrix() {
		String currentDirectory;
		String newDirectory;
		boolean checkfileexists = false;
		
		Price_Initializer price_init = new Price_Initializer();
		currentDirectory = price_init.getCurrentDirectory();
		
		newDirectory = currentDirectory;
		
		try {
			File pricematrix_file = new File(newDirectory);
			
			FileInputStream fis = new FileInputStream (pricematrix_file);
			
			Scanner sc = new Scanner(fis);
			
			HashMap<String,String> mapInFile=new HashMap<String,String>();
			
			String currentLine;
			
			while(sc.hasNextLine()) {
				currentLine = sc.nextLine();
				
				//tokenize the currentLine
				StringTokenizer st = new StringTokenizer(currentLine, "=", false);
				
				//put tokens of currentLine in map
				mapInFile.put(st.nextToken(), st.nextToken());
			}
			fis.close();
			
			//PricingManager pm = new PricingManager(mapInFile);
		} catch (Exception e) {
			
		}
		
		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		Price_Initializer price_init = new Price_Initializer();
		price_init.CreatePriceMatrixFile();
	}

}
