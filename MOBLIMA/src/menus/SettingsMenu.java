package menus;
import managers.PricingManager;
import managers.SettingsManager;
import managers.MovieManager;
import entities.Movie;
import enums.*;

public class SettingsMenu {
    Scanner sc = new Scanner(System.in);

	// Settings Display Menuy
	public void displayMenu() {
		int choice;
		do {
            System.out.println("=================== Settings ===================");
            System.out.println("1. Price Settings");
            System.out.println("2. Movie Settings");
            System.out.println("3. Holiday Settings");
            System.out.println("0. Back to Staff App");
            System.out.println("==========================================================");
            System.out.println("Select Option: ");
            while(!sc.hasNextInt()) {
                System.out.println("Please enter a number!");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();
            
			switch (choice) {
				case 1:
					priceSettings();
					break;
				case 2:
                    movieSettings();
					break;
                case 3:
                    holidaySettings();
					break;
				case 0:
					System.out.println("Moving back to Staff App");
					break;
				default:
					System.out.println("Invalid option. Please choose an option between 0-4.");
					break;
			}
		} while (choice!=0);
	}

    private void priceSettings(){
        int choice;
		do {
	        System.out.println(	"=================== Price Settings ===================");
            System.out.println(" 1. View Price Settings");
            System.out.println(" 2. Edit Price Settings");
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");

			System.out.println("Enter choice:");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();
				
			switch (choice) {
				case 1: 
					viewPriceSettings();
					break;
				case 2:
					editPriceSettings();
					break;
				case 0:
					System.out.println("Back to SystemSettings Menu......");
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-8.");
					break;
			}
		} while (choice!=0);
    }

	// View Price Settings
	private void editPriceSettings() {
		int choice;
		do {
	        System.out.println("=================== Edit Price Settings ===================");
            System.out.println(" 1. Base Prices");
            System.out.println(" 2. Age Group Prices");
            System.out.println(" 3. Cinema Type Prices");
            System.out.println(" 4. Day of Week Prices");
            System.out.println(" 5. Time of Day Prices");
            System.out.println(" 6. Type of Day Prices");
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");

			System.out.println("Enter choice:");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();
				
			switch (choice) {
				case 1: 
                    double newbase;
                    System.out.println("Current Base Price: " + PricingManager.getPrice(BASE_PRICE));
                    System.out.println("Enter New Base Price: ");
                    newbase = sc.nextDouble();
					PricingManager.updatePrice(BASE_PRICE,newbase);
					break;
				case 2:
					int ageGroupChoice;
                    double newageprice;
                    do {
                        System.out.println(" 1. Adult Prices");
                        System.out.println(" 2. Senior Prices");
                        System.out.println(" 3. Student Prices");
                        System.out.println(" 0. Back to Pricing");
                        System.out.println("Enter choice:");
                        ageGroupChoice = sc.nextInt();
                        System.out.println("Enter new Price: ");
                        newageprice = sc.nextDouble();
                        switch(ageGroupChoice){
                            case 1:
                                PricingManager.updatePrice(AgeGroup.ADULT, newageprice);
                                System.out.println("Price of ADULT updated to " + PricingManager.getPrice(AgeGroup.ADULT));
                                break;
                            case 2:
                                PricingManager.updatePrice(AgeGroup.SENIOR, newageprice);
                                System.out.println("Price of SENIOR updated to " + PricingManager.getPrice(AgeGroup.SENIOR));
                                break;
                            case 3:
                                PricingManager.updatePrice(AgeGroup.STUDENT, newageprice);
                                System.out.println("Price of STUDENT updated to " + PricingManager.getPrice(AgeGroup.STUDENT));
                                break;
                            case 0:
                                System.out.println("Back to Price Settings......");
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose between 0-3.");
                                break;
                        }
                    } while (ageGroupChoice != 0);
					break;
				case 3:
                    int cinemaTypeChoice;
                    double newcinematypeprice;
                    do {
                        System.out.println(" 1. IMAX Prices");
                        System.out.println(" 2. 3D Prices");
                        System.out.println(" 3. NORMAL Prices");
                        System.out.println(" 0. Back to Pricing");
                        System.out.println("Enter choice:");
                        cinemaTypeChoice = sc.nextInt();
                        System.out.println("Enter new Price: ");
                        newcinematypeprice = sc.nextDouble();
                        switch(cinemaTypeChoice){
                            case 1:
                                PricingManager.updatePrice(CinemaType.IMAX, newcinematypeprice);
                                System.out.println("Price of IMAX updated to " + PricingManager.getPrice(CinemaType.IMAX));
                                break;
                            case 2:
                                PricingManager.updatePrice(CinemaType._3D, newcinematypeprice);
                                System.out.println("Price of SENIOR updated to " + PricingManager.getPrice(CinemaType._3D));
                                break;
                            case 3:
                                PricingManager.updatePrice(CinemaType.NORMAL, newcinematypeprice);
                                System.out.println("Price of STUDENT updated to " + PricingManager.getPrice(CinemaType.NORMAL));
                                break;
                            case 0:
                                System.out.println("Back to Price Settings......");
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose between 0-3.");
                                break;
                        }
                    } while (cinemaTypeChoice != 0);
                    break;
				case 4:
                    int dowChoice;
                    double newdowprice;
                    do {
                        System.out.println(" 1. MONDAY Prices");
                        System.out.println(" 2. TUESDAY Prices");
                        System.out.println(" 3. WEDNESDAY Prices");
                        System.out.println(" 4. THURSDAY Prices");
                        System.out.println(" 5. FRIDAY Prices");
                        System.out.println(" 6. SATURDAY Prices");
                        System.out.println(" 7. SUNDAY Prices");
                        System.out.println(" 0. Back to Pricing");
                        System.out.println("Enter choice:");
                        dowChoice = sc.nextInt();
                        System.out.println("Enter new Price: ");
                        newdowprice = sc.nextDouble();
                        switch(dowChoice){
                            case 1:
                                PricingManager.updatePrice(DayOfWeek.MON, newdowprice);
                                System.out.println("Price of MON updated to " + PricingManager.getPrice(DayOfWeek.MON));
                                break;
                            case 2:
                                PricingManager.updatePrice(DayOfWeek.TUE, newdowprice);
                                System.out.println("Price of TUE updated to " + PricingManager.getPrice(DayOfWeek.TUE));
                                break;
                            case 3:
                                PricingManager.updatePrice(DayOfWeek.WED, newdowprice);
                                System.out.println("Price of WED updated to " + PricingManager.getPrice(DayOfWeek.WED));
                                break;
                            case 4:
                                PricingManager.updatePrice(DayOfWeek.THU, newdowprice);
                                System.out.println("Price of THU updated to " + PricingManager.getPrice(DayOfWeek.THU));
                                break;
                            case 5:
                                PricingManager.updatePrice(DayOfWeek.FRI, newdowprice);
                                System.out.println("Price of FRI updated to " + PricingManager.getPrice(DayOfWeek.FRI));
                                break;
                            case 6:
                                PricingManager.updatePrice(DayOfWeek.SAT, newdowprice);
                                System.out.println("Price of SAT updated to " + PricingManager.getPrice(DayOfWeek.SAT));
                                break;
                            case 7:
                                PricingManager.updatePrice(DayOfWeek.SUN, newdowprice);
                                System.out.println("Price of SUN updated to " + PricingManager.getPrice(DayOfWeek.SUN));
                                break;
                            case 0:
                                System.out.println("Back to Price Settings......");
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose between 0-7.");
                                break;
                        }
                    } while (dowChoice != 0);
					break;
				case 5:
                    int statusChoice;
                    double newstatusprice;
                    do {
                        System.out.println(" 1. Before 6PM Prices");
                        System.out.println(" 2. After 6PM Prices");
                        System.out.println(" 0. Back to Pricing");
                        System.out.println("Enter choice:");
                        statusChoice = sc.nextInt();
                        System.out.println("Enter new Price: ");
                        newstatusprice = sc.nextDouble();
                        switch(statusChoice){
                            case 1:
                                PricingManager.updatePrice(TimeOfDay.BEFORE_6, newstatusprice);
                                System.out.println("Price Before 6PM updated to " + PricingManager.getPrice(TimeOfDay.BEFORE_6));
                                break;
                            case 2:
                                PricingManager.updatePrice(TimeOfDay.AFTER_6, newstatusprice);
                                System.out.println("Price After 6PM updated to " + PricingManager.getPrice(TimeOfDay.AFTER_6));
                                break;
                            case 0:
                                System.out.println("Back to Price Settings......");
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose between 0-2.");
                                break;
                        }
                    } while (statusChoice != 0);
                    break;
				case 6:
                    int todChoice;
                    double newtodprice;
                    do {
                        System.out.println(" 1. WEEKEND Prices");
                        System.out.println(" 2. WEEKDAY Prices");
                        System.out.println(" 3. PUBLIC HOLIDAY Prices");
                        System.out.println(" 0. Back to Pricing");
                        System.out.println("Enter choice:");
                        todChoice = sc.nextInt();
                        System.out.println("Enter new Price: ");
                        newtodprice = sc.nextDouble();
                        switch(todChoice){
                            case 1:
                                PricingManager.updatePrice(TypeOfDay.IMAX, WEEKEND);
                                System.out.println("Price of WEEKEND updated to " + PricingManager.getPrice(TypeOfDay.WEEKEND));
                                break;
                            case 2:
                                PricingManager.updatePrice(TypeOfDay.WEEKDAY, newtodprice);
                                System.out.println("Price of WEEKDAY updated to " + PricingManager.getPrice(TypeOfDay.WEEKDAY));
                                break;
                            case 3:
                                PricingManager.updatePrice(TypeOfDay.PUBLIC_HOLIDAY, newtodprice);
                                System.out.println("Price of PUBLIC HOLIDAY updated to " + PricingManager.getPrice(TypeOfDay.PUBLIC_HOLIDAY));
                                break;
                            case 0:
                                System.out.println("Back to Price Settings......");
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose between 0-3.");
                                break;
                        }
                    } while (todChoice != 0);
					break;
				case 0:
					System.out.println("Back to Settings Menu......");
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-8.");
					break;
			}
		} while (choice!=0);
	}

	// View Price Settings
	private void viewPriceSettings() {
		int choice;
		do {
	        System.out.println(	"=================== View Price Settings ==================");
            System.out.println(" 1. Base Prices");
            System.out.println(" 2. Age Group Prices");
            System.out.println(" 3. Cinema Type Prices");
            System.out.println(" 4. Day of Week Prices");
            System.out.println(" 5. Time of Day Prices");
            System.out.println(" 6. Type of Day Prices");
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");
			System.out.println("Enter choice: ");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();
				
			switch (choice) {
				case 1:
                    
                    break;
				case 2:
					System.out.println("Adult Price: $" + PricingManager.getPrice(AgeGroup.ADULT));
                    System.out.println("Senior Price: $" + PricingManager.getPrice(AgeGroup.SENIOR));
                    System.out.println("Student Price: $" + PricingManager.getPrice(AgeGroup.STUDENT));
					break;
				case 3: 
                    System.out.println("IMAX Price: $" + PricingManager.getPrice(CinemaType.IMAX));
                    System.out.println("3D Price: $" + PricingManager.getPrice(CinemaType._3D));
                    System.out.println("Normal Price: $" + PricingManager.getPrice(CinemaType.NORMAL));
					break;
				case 4:
                    System.out.println("Monday Price: $" + PricingManager.getPrice(DayOfWeek.MON));
                    System.out.println("Tuesday Price: $" + PricingManager.getPrice(DayOfWeek.TUE));
                    System.out.println("Wednesday Price: $" + PricingManager.getPrice(DayOfWeek.WED));
                    System.out.println("Thursday Price: $" + PricingManager.getPrice(DayOfWeek.THU));
                    System.out.println("Friday Price: $" + PricingManager.getPrice(DayOfWeek.FRI));
                    System.out.println("Saturday Price: $" + PricingManager.getPrice(DayOfWeek.SAT));
                    System.out.println("Sunday Price: $" + PricingManager.getPrice(DayOfWeek.SUN));
					break;
				case 5:
                    System.out.println("Before 6PM Price: $" + PricingManager.getPrice(TimeOfDay.BEFORE_6));
                    System.out.println("After 6PM Price: $" + PricingManager.getPrice(TimeOfDay.AFTER_6));
					break;			
				case 6:
                    System.out.println("Weekend Price: $" + PricingManager.getPrice(TypeOfDay.WEEKEND));
                    System.out.println("Weekday Price: $" + PricingManager.getPrice(TypeOfDay.WEEKDAY));
                    System.out.println("Public Holiday Price: $" + PricingManager.getPrice(TypeOfDay.PUBLIC_HOLIDAY));
					break;
				case 0: 
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-7.");
					break;
			}
		} while (choice!=0);
		
		System.out.println("Back to Price Settings......");
	}

    public void movieSettings() {
		int choice;
		do {
            System.out.println(	"============== Movie Settings ================\n" +
			                    " 1. Edit Movie          					        \n" +
			                    " 2. Add Movie                                     \n" +
			                    " 3. Delete Movie                                  \n" +
			                    " 0. Back to Settings Menu                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice){
                case 1:
                	// EDIT MOVIE
					// MOVIE EDITOR MENU
						// ASK WHAT MOVIE (LIST ALL MOVIES)
							// ASK WHICH ATTRIBUTE TO CHANGE
							// ASK FOR VALUE
							// CALL MOVIEMANAGER(MOVIE, ATTRIBUTE, VALUE), VALIDATE IN MOVIEMANAGER
							// CHECK RESPONSE FROM MOVIEMANGER, REPEAT IF NEEDED
                	
                	System.out.println(	"================ SELECT A MOVIE =================");
                	ArrayList<Movie> editmovie = new ArrayList<Movie>();
                    int editchoice = -1;

                    //editmovie = MovieConsolidator.getInstance().getAll();
                    do {
                    	
                    	System.out.println("Choose a movie or enter 0 to exit : ");
                            
                        while (!sc.hasNextInt()) {
                    		System.out.printf("Invalid input type.");
                    		sc.next(); 
                    	}
                        editchoice = sc.nextInt();
                        
                        }while(editchoice  < 0 || editchoice >= 10);//movies.size()
                    	sc.nextLine();
                    
                      
                   // Movie targetedit = editmovie.get(editchoice);
                    int subchoice;
                    do {
                        System.out.println("=================== Choose what to eidt ==================\n" +
                                            " 1. Edit Movie Title      	                                \n" +
                                            " 2. Edit Movie Genres                      	        	\n" +
                                            " 3. Edit Movie Status	                                    \n" +
                                            " 4. Edit Movie Cast                                        \n" +
                                            " 5. Edit Movie Director                                     \n" +
                                            " 6. Edit Movie Synopsis                                     \n" +
                                            " 0. Finish Editing Movie                                \n"+
                                            "=========================================================");
                        System.out.println("Enter choice: ");
                        
                        while (!sc.hasNextInt()) {
                        	System.out.println("Invalid input type. Please enter an integer value between 0-10.");
                    		sc.next(); // Remove newline character
                        }
                        
                        subchoice = sc.nextInt();
                        sc.nextLine();
                        switch (subchoice) {
                            case 1:
                                System.out.println("Movie title: ");
                                while (!sc.hasNext()) {
                                	System.out.println("Invalid input type. Please try again!");
                            		sc.next(); 
                                }
                                String title = sc.nextLine();
                               
                                System.out.println("Movie title "+ title); 
                                //targetedit.setMovieName(title);
 
                                break;
                            case 2:
                                System.out.println("Movie Genre (IMAX/_3D/NORMAL): ");
                                while (!sc.hasNext()) {
                                	System.out.println("Invalid input type. Please try again!");
                            		sc.next(); 
                                }
                                
                                String askgenre = sc.nextLine();
                                CinemaType genre = null;
                                try 
                                {
                                	genre = CinemaType.valueOf(askgenre);
                                }
                                catch(IllegalArgumentException e)
                                {
                                	System.out.println("Invalid input type!!. Please follow the status format");
                                }
                                
                                System.out.println("Movie genre "+ genre); 
                                //targetedit.setMovieType(genre);

                                break;
                            case 3:
                                System.out.println("Status (ComingSoon/Showing): ");
                                while (!sc.hasNext()) {
                                	System.out.println("Invalid input type. Please try again!");
                            		sc.next(); 
                                }
                                
                                String askstatus = sc.nextLine();
                                Status status = null;
                                try 
                                {
                                	status = Status.valueOf(askstatus);
                                }
                                catch(IllegalArgumentException e)
                                {
                                	System.out.println("Invalid input type!!. Please follow the status format");
                                }
                                
                                System.out.println("Movie status "+ status); 
                                //targetedit.setStatus(status);
                                break;
                            case 4:
                                ArrayList<String> cast = new ArrayList<String>();  
                                System.out.println("Enter 2 cast: ");  
                                for(int i=0; i<2; i++)  
                                {  
                                    System.out.println("Please enter cast " +(i+1)+ ":");
                                	cast.add(sc.next());  
                                }  
                                //targetedit.setCasts(cast);
                                break;
                            case 5:
                            	
                                System.out.println("Movie Director: ");
                                while (!sc.hasNext()) {
                                	System.out.println("Invalid input type. Please try again!");
                            		sc.next(); 
                                }
                                String director = sc.nextLine();
                                
                                System.out.println("Movie director "+ director); 
                                //targetedit.setDirector(director);
                                
                                break;
                            case 6:
                                System.out.println("Movie Sypnopsis: ");
                                while (!sc.hasNext()) {
                                	System.out.println("Invalid input type. Please try again!");
                            		sc.next(); 
                                }
                                String sypnopsis = sc.nextLine();
                                
                                System.out.println("Movie sypnopsis "+ sypnopsis); 
                               // targetedit.setSypnopsis(sypnopsis);
                                
                                break;
                            case 0:
                                System.out.println("=============Exiting Edit=============");
                                break;
                            default:
                                System.out.println("Please enter a number from 0-10: ");
                        }
                    } while (subchoice != 0);
                    break;
                case 2:
                	// ADD MOVIE
					// ASK FOR ALL NECESSARY ATTRIBUTE
					// MOVIEMANAGER.ADDMOVIE(...) - RMB TO VALIDATE
                    System.out.println("Movie title: ");
                    while (!sc.hasNext()) {
                    	System.out.println("Invalid input type. Please try again!");
                		sc.next(); 
                    }
                    String title = sc.nextLine();
                    
                    System.out.println("Movie Genre (IMAX/_3D/NORMAL): ");
                    while (!sc.hasNext()) {
                    	System.out.println("Invalid input type. Please try again!");
                		sc.next(); 
                    }
                    
                    String askgenre = sc.nextLine();
                    CinemaType genre = null;
                    try 
                    {
                    	genre = CinemaType.valueOf(askgenre);
                    }
                    catch(IllegalArgumentException e)
                    {
                    	System.out.println("Invalid input type!!. Please follow the status format");
                    }
                    
                    System.out.println("Status (ComingSoon/Showing): ");
                    while (!sc.hasNext()) {
                    	System.out.println("Invalid input type. Please try again!");
                		sc.next(); 
                    }
                    
                    String askstatus = sc.nextLine();
                    Status status = null;
                    try 
                    {
                    	status = Status.valueOf(askstatus);
                    }
                    catch(IllegalArgumentException e)
                    {
                    	System.out.println("Invalid input type!!. Please follow the status format");
                    }
                    
             
                    ArrayList<String> cast = new ArrayList<String>();  
                    System.out.println("Enter 2 cast: ");  
                    for(int i=0; i<2; i++)  
                    {  
                        System.out.println("Please enter cast " +(i+1)+ ":");
                    	cast.add(sc.next());  
                    }    
  
                    
                    System.out.println("Movie Director: ");
                    while (!sc.hasNext()) {
                    	System.out.println("Invalid input type. Please try again!");
                		sc.next(); 
                    }
                    String director = sc.nextLine();
                    
                    System.out.println("Movie Sypnopsis: ");
                    while (!sc.hasNext()) {
                    	System.out.println("Invalid input type. Please try again!");
                		sc.next(); 
                    }
                    String sypnopsis = sc.nextLine();
                    
                    ArrayList<Integer> ratings = new ArrayList<>();
                    float avg = 0.000f;
                    Movie newmovie = new Movie(0,title,genre,status,cast,director,sypnopsis,ratings,0.0,avg); //movieID should be size()+1?
                    
                    MovieManager.getInstance().addMovie(newmovie);                    

                    break;
                case 3:
                	// DELETE MOVIE
					// ASK WHAT MOVIE (LIST ALL MOVIES)
					// CONFIMATION PAGE
                	System.out.println(	"================ SELECT A MOVIE =================");
                	ArrayList<Movie> delete = new ArrayList<Movie>();
                    int deletechoice = -1;

                    //delete = MovieConsolidator.getInstance().getAll();
                    do {
                    	System.out.println("Choose a movie or enter 0 to exit : ");
                            
                        while (!sc.hasNextInt()) {
                    		System.out.printf("Invalid input type.");
                    		sc.next(); 
                    	}
                        deletechoice = sc.nextInt();
                        
                        }while(deletechoice  < 0 || deletechoice >= 10);//movies.size()
                    sc.nextLine(); 
                    System.out.println("Enter Y to confirm delete : ");
                    String confirmation = sc.nextLine();

                    if(confirmation.equals("Y"))
                    {
                    	System.out.println("SUCCESSFULLY DELETED");
                    	//MovieManager.removeMovieByID(deletechoice);
                    }
                    else
                    {
                    	System.out.println("DELETE UNSUCCESSFULLY");
                    	break;
                    }
                    break;
                case 0:
                	System.out.println("Back to MOBLIMA APP......");
                	break;
                default: 
                	System.out.println("Invalid choice.");
                	break;
	            }
	        } while (choice != 0);
		}


    // Holiday Settings
    private void holidaySettings(){
        int choice;
		do {
	        System.out.println(	"=================== Holiday Settings ===================");
            System.out.println(" 1. View all Holidays");
            System.out.println(" 2. Add New Holiday");
            System.out.println(" 3. Remove Exisiting Holiday")
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");

			System.out.println("Enter choice:");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();
				
			switch (choice) {
				case 1: 
                    // display list of all movies with directors
                    // search fucntion for movie??
					SettingsManager.listHolidays();
					break;
				case 2:
                    // Add new movie
					SettingsManager.addNewHoliday();
					break;
                case 3:
                    // Remove Holiday
					SettingsManager.removeExistingHoliday();
					break;
				case 0:
					System.out.println("Back to Settings Menu......");
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-8.");
					break;
			}
		} while (choice!=0);
    }
}
