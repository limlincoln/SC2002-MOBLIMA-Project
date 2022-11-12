package menus;

import java.util.Scanner;

import entities.Cinema;
import entities.Cineplex;
import enums.DayOfWeek;
import managers.CineplexManager;
import managers.ShowTimeManager;

public class ShowTimeEditorMenu {
    public static void startShowTimeEditor() {
        Cineplex cineplex = CineplexSelectorMenu.getInstance().startSelector(CineplexManager.getInstance().getCineplexs(), "Select a Cinplex");
        Cinema cinema = CinemaSelectorMenu.getInstance().startSelector(cineplex.getCinemas(), "Select a Cinema");

        int index = 1;
        for(DayOfWeek day: DayOfWeek.values()) {
            System.out.println("("+index+")" +day);
            index++;
        }

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            choice = sc.nextInt();
        } while(choice < 1 || choice > DayOfWeek.values().length);

        ShowTimeManager.getInstance().editShowTime(cineplex, cinema, DayOfWeek.values()[choice-1]);

        sc.close();
    }
    
}
