package menus;

import java.util.ArrayList;
import java.util.Scanner;

import consolidators.MovieConsolidator;
import enums.Status;
import managers.MovieManager;
import enums.CinemaType;
import entities.Movie;

public class MovieMenu {
    private static MovieMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private MovieMenu(){}


    public static MovieMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new MovieMenu();
        return single_instance;
    }
    
	public void displayCustomerMovieMenu() {
		int choice;
		
		do {
            System.out.println(	"============== MOBLIMA CUSTOMER MOVIE APP =========\n" +
			                    " 1. List all movies     					        \n" +
			                    " 2. List top 5 movie                               \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                	// should show only now showing movie list?
                	System.out.println(	"================ SELECT A MOVIE =================");
                	ArrayList<Movie> movies = new ArrayList<Movie>();
                    int subChoice;

                    movies = MovieConsolidator.getInstance().getShowing();

                    // TODO: Display all movies by looping through array list

                    do {
                    	
                    	System.out.println("Choose a movie or enter 0 to exit : ");
                            
                        while (!sc.hasNextInt()) {
                    		System.out.printf("Invalid input type.");
                    		sc.next(); 
                    	}
                        subChoice = sc.nextInt()-1;
                        
                        }while(subChoice  < 0 || subChoice >= movies.size());
                    	
                        Movie selectedMovie = movies.get(subChoice); 
                        
                        CineplexMenu.getInstance().displayCineplexMenu(selectedMovie); // display cineplex instead
                        
                    break;
                    
                    
                    
                case 2:
                	// List top 5 movies
                	ArrayList<Movie> topmovies = new ArrayList<Movie>();
                	topmovies.get(0).showDetails();
                    break;
                case 0:
                	System.out.println("Back to MOBLIMA APP");
                	break;
                default: 
                	System.out.println("Please enter an integer value or correct value.");
                	break;
	            }
	        } while (choice != 0);
		}
	
	public void displayStaffMovieMenu() {
		int choice;

		
		do {
            System.out.println(	"============== MOBLIMA STAFF APP ================\n" +
			                    " 1. Edit Movie          					        \n" +
			                    " 2. Add Movie                                     \n" +
			                    " 3. Delete Movie                                  \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
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



}
