package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import utils.SeatPrinter;
import enums.AgeGroup;
import menus.AgeGroupMenu;

public class SeatSelector implements ISeatSelector{
    @Override
    public HashMap<String, AgeGroup> StartSeatSelectionInstance(ISeats seats) {
        Scanner sc = new Scanner(System.in);
        SeatPrinter sp = SeatPrinter.getInstance();

        ArrayList<Integer[]> selected = new ArrayList<Integer[]>();
        HashMap<String, AgeGroup> result = new HashMap<String, AgeGroup>();
        while(true){
            sp.print(seats);
            System.out.println("\n 1. Select/Deselect Seat   \n " +
                                    "2. Confirm              \n " +
                                    "0. Cancel                  " );
            int choice = sc.nextInt(); // Remove newline character
            ISeat[][] curSeats = seats.getSeats();
            switch(choice){
                case 1:
                    System.out.println("Enter seat of Choice eg. A0");
                    sc.nextLine();
                    String input = sc.nextLine().toUpperCase();
                    Integer colSelected = ((int)input.charAt(0)) - 65;
                    Integer rowSelected = Integer.parseInt(input.substring(1));
                    if(rowSelected >= curSeats.length || colSelected >= curSeats.length || curSeats[rowSelected][colSelected] instanceof Space){
                        System.out.println("Invalid Seat Selected");
                        continue;
                    }else{
                        Integer[] choices = new Integer[2];
                        choices[0] = rowSelected;
                        choices[1] = colSelected;
                        // check if seat is to be selected of de-selected
                        if(result.get(input) != null){
                            result.remove(input);
                            // remove choices in selected array
                            for(int i=0; i<selected.size(); i++){
                                if(Arrays.equals(selected.get(i), choices)){
                                    selected.remove(i);
                                    continue;
                                }
                            }
                        }else{
                            // ask for age group;
                            AgeGroup ageGroup = AgeGroupMenu.getInstance().display();
                            result.put(input, ageGroup);
                            selected.add(choices);
                        }

                        Seat seatChoice = (Seat) curSeats[rowSelected][colSelected];
                        seatChoice.toggleTempSelected();
                        
                    }
                    // TODO: ASK WHAT AGE GROUP & SAVE IT IN ARRAY
                
                    break;
                case 2:
                    if(selected.size() == 0){
                        System.err.println("No Seats Selected");
                        return null;
                    }else{
                        for(int i=0; i<selected.size(); i++){
                            Integer[] s = selected.get(i);
                            Seat seat = (Seat) curSeats[s[0]][s[1]];
                            seat.toggleOccupied();
                            seat.toggleTempSelected();
                        }
                        System.out.println("Number of seats chosen: " + selected.size());
                        return result;
                        // PASS OUT ARRAY OF SELECTED SEAT INFO
                    }
                case 0:
                default:
                    for(int i=0; i<selected.size(); i++){
                        Integer[] s = selected.get(i);
                        Seat seat = (Seat) curSeats[s[0]][s[1]];
                        seat.toggleTempSelected();
                    }
                    return null;                    
            }
        }        
    }   
}