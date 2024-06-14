package MVC;

import MVC.Controller.*;
import MVC.Model.GameClasses.GameMap;
import MVC.Controller.Render;

import java.util.Scanner;

public class Simulation {
    private int countRounds = 0;
    private int countRoundsSet = 0;
    public void start() {
        // создали карту
        GameMap map2 = new GameMap(Settings.MAP_LENGTH
                                  ,Settings.MAP_WIDTH
        );
        Actions.initActions(map2);

        while (true) {

            System.out.println();System.out.println();System.out.println();
            System.out.println("Раунд: " + countRounds);
            Render.printMap(map2);

            if (countRoundsSet == 0) {

                Scanner in2 = new Scanner(System.in);
                System.out.println();
                System.out.println("Введите число, сколько ходов нужно просимулировать.");
                countRoundsSet = in2.nextInt();
            } else {
                countRoundsSet--;
            }

            Actions.turnActions(map2);
            countRounds++;
        }
    }

}
