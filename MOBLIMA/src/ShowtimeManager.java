package managers;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
//import utils.SerializerHelper;
//import utils.ProjectRootPathFinder;


public class ShowtimeManager {
    private Showtime showtimes;
    private Scanner sc = new Scanner(System.in);
    private Map <String, Showtime> showtimes = new HashMap<String, Showtime>();

    //intialiser
    private ShowtimeManager() {
        Map <String, Showtime> showtimeMap = this.load();
        if (showtimeMap != null) {
            this.showtimes = showtimeMap;
        }
    }
    
    //handles adding of movie to showtime list in cinema
    void getMovieShowtimes(String movieID, String appType) {
        //getting the list of movies
        //need to import showimt and movie manager
        List<String> relevantShowtimeIDs = MovieManager.getInstance().getMoviebyID(movieID).getShowtimeIDs();
        //getting relevant showtimes
        List<Showtime> relevantShowtimes = new ArrayList<Showtime>();
        for (String showtimeID : relevantShowtimeIDs) {
            Showtime showtime = this.showtimes.get(showtimeID);
            relevantShowtimes.add(showtime);
        }

        int choice;
        // displays showtimes to users

        do {
            System.out.println("List of showtimes: ");
            int j;
            if (relevantShowtimes.size() == 0) {
                System.out.println("No existing showtimes found.");
            }
            else {
                for (j = 0; j < relevantShowtimes.size(); j++) {
                    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd MMM yyyy, hh.mma");
                    System.out.println((j + 1) + ". " + relevantShowtimes.get(j).getCineplexName() + ", Cinema " + relevantShowtimes.get(j).getCinema().getCinemaID() + ", Hall No. " + relevantShowtimes.get(j).getCinema().getHallNo());
                    System.out.println("  " + "Movie Format: " + relevantShowtimes.get(j).getMovieFormat());
                    System.out.printf("  Date/Time: %s\n", relevantShowtimes.get(j).getDateTime().format(formatter));
                    System.out.println("");
                }
            }

            //some existing showtimes
            if (appType.equalsIgnoreCase("Staff") && relevantShowtimes.size()!=0) {
                System.out.println("==================== SHOWTIMES  =====================");
                System.out.println(" 1. Edit Showtimes");
                System.out.println(" 2. Create New Showtime");
                System.out.println(" 0. Back to Showtimes List");
                System.out.println("=====================================================");

                System.out.println("Enter choice:");
                while(!sc.hasNextInt()) {
                    System.out.println("Please enter a number between 0-2");
                    sc.next();
                }

                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter showtime: ");
                        while(!sc.hasNextInt()) {
                            System.out.println("Please enter a number");
                            sc.next();
                        }
                        int value = sc.nextInt() - 1;
                        while (value >= relevantShowtimeIDs.size() || value < 0) {
                            System.out.println("Please enter a number from 0 to " + relevantShowtimeIDs.size());
                            value = sc.nextInt() - 1;
                        }
                        String showtimeID = relevantShowtimeIDs.get(value);
                        this.showtimeMenuStaff(showtimeID);
                        break;

                    case 2:
                        Showtime showtime = this.createShowtime(movieID);
                        relevantShowtimes.add(showtime);
                        break;

                    case 0:
                        System.out.println("Moving back to Showtimes List");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose between 0-2");
                        break;
                }
            }

            //there are no relevant showtimes
            else if (appType.equalsIgnoreCase("Staff") && relevantShowtimes.size() == 0) {
                System.out.println("==================== SHOWTIMES  =====================");
                System.out.println(" 1. Create New Showtime");
                System.out.println(" 0. Back to Showtimes List");
                System.out.println("=====================================================");
                System.out.println("Enter choice:");
                while(!sc.hasNextInt()) {
                    System.out.println("Please enter a number!");
                    sc.next();
                }
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        Showtime showtime = this.createShowtime(movieID);
                        relevantShowtimes.add(showtime);
                        break;
                    case 0:
                        System.out.println("Back to Showtimes List......");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose between 0-1");
                        break;
                }
            }
        } while (choice != 0);
    }
}
