package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import utils.SeatPrinter;

public class SeatSelector implements ISeatSelector{
    @Override
    public int StartSeatSelectionInstance(ISeats seats) {
        Scanner sc = new Scanner(System.in);
        SeatPrinter sp = SeatPrinter.getInstance();

        ArrayList<Integer[]> selected = new ArrayList<Integer[]>();
        while(true){
            sp.print(seats);
            System.out.println("\n 1. Select/Deselect Seat   \n " +
                                    "2. Confirm              \n " +
                                    "0. Cancel                  " );
            int choice = sc.nextInt(); // Remove newline character
            switch(choice){
                case 1:
                    System.out.println("Enter seat of Choice eg. A0");
                    sc.nextLine();
                    String input = sc.nextLine().toUpperCase();
                    Integer colSelected = ((int)input.charAt(0)) - 65;
                    Integer rowSelected = Integer.parseInt(input.substring(1));
                    if(rowSelected >= seats.getSeats().length || colSelected >= seats.getSeats().length || seats.getSeats()[rowSelected][colSelected] instanceof Space){
                        System.out.println("Invalid Seat Selected");
                        continue;
                    }else{
                        Seat seatChoice = (Seat) seats.getSeats()[rowSelected][colSelected];
                        seatChoice.toggleTempSelected();
                        Integer[] choices = new Integer[2];
                        choices[0] = rowSelected;
                        choices[1] = colSelected;
                        for(int i=0; i<selected.size(); i++){
                            if(Arrays.equals(selected.get(i), choices)){
                                selected.remove(i);
                                continue;
                            }
                        }
                        selected.add(choices);
                    }
                    // TODO: ASK WHAT AGE GROUP & SAVE IT IN ARRAY
                
                    break;
                case 2:
                    if(selected.size() == 0){
                        System.err.println("No Seats Selected");
                        return selected.size();
                    }else{
                        for(int i=0; i<selected.size(); i++){
                            Integer[] s = selected.get(i);
                            Seat seat = (Seat) seats.getSeats()[s[0]][s[1]];
                            seat.toggleOccupied();
                            seat.toggleTempSelected();
                        }
                        System.out.println("Number of seats chosen: " + selected.size());

                        // PASS OUT ARRAY OF SELECTED SEAT INFO
                    }
                    return selected.size();
                case 0:
                default:
                    for(int i=0; i<selected.size(); i++){
                        Integer[] s = selected.get(i);
                        Seat seat = (Seat) seats.getSeats()[s[0]][s[1]];
                        seat.toggleTempSelected();
                    }
                    return 0;                    
            }
        }        
    }   
}
