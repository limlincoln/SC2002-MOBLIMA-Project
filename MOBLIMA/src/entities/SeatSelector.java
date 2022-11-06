package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SeatSelector implements ISeatSelector{
    @Override
    public int StartSeatSelectionInstance(ISeats seats) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        ArrayList<Integer[]> selected = new ArrayList<Integer[]>();
        while(true){
            seats.showSeats();
            System.out.println("\n 1. Select/Deselect Seat   \n " +
                                    "2. Confirm              \n " +
                                    "0. Cancel                  " );
            choice = sc.nextInt(); // Remove newline character
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
                    }
                    return selected.size();
                case 3:
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
