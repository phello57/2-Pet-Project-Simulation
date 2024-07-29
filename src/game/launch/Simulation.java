package game.launch;

import game.control.*;
import game.model.game_entities.GameMap;
import game.view.Render;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Simulation {
    private int countRounds = 1;
    private int countRoundsSet = 0;
    public void start() {

        GameMap game = new GameMap(Settings.MAP_LENGTH
                                  ,Settings.MAP_WIDTH);

        Control control = new Control(game);
        Render render = new Render(game);

        control.initAction();

        while (true) {

            System.out.println("\n\n\n");
            System.out.println("Раунд: " + countRounds);

            render.printMap();

            if (countRoundsSet == 0) {
                askValue();
                countRoundsSet -= 1;
            } else {
                countRoundsSet -= 1;
            }

            control.turnActions();
            countRounds += 1;
        }
    }

    private void askValue() {
        System.out.println("\nВведите число, сколько ходов нужно просимулировать.");
        Scanner in2 = new Scanner(System.in);

        try {
            countRoundsSet = in2.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введено не верное значение, Введите число");
            askValue();
        }
        if (countRoundsSet < 0) {
            System.out.println("Введено не верное значение, Введите положительное число");
            askValue();
        }

    }
}
