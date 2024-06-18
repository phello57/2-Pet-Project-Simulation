package MVC;

import MVC.Controller.*;
import MVC.model.game_entities.GameMap;
import MVC.view.Render;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Simulation {
    private int countRounds = 0;
    private int countRoundsSet = 0;
    public void start() {

        GameMap game = new GameMap(Settings.MAP_LENGTH
                                  ,Settings.MAP_WIDTH
        );
        Actions.initActions(game);

        while (true) {

            System.out.println();System.out.println();System.out.println();
            System.out.println("Раунд: " + countRounds);
            Render.printMap(game);

            if (countRoundsSet == 0) {

                askValue();
            } else {
                countRoundsSet -= 1;
            }

            Actions.turnActions(game);
            countRounds += 1;
        }
    }
    private void askValue() {
        Scanner in2 = new Scanner(System.in);
        System.out.println();
        System.out.println("Введите число, сколько ходов нужно просимулировать.");
        try {
            countRoundsSet = in2.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введено не верное значение, Введите число");
            askValue();
        }
    }
}
