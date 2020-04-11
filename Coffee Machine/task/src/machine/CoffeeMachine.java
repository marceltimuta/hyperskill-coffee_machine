package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CoffeeMachineRobot coffeeMachineRobot = new CoffeeMachineRobot(scanner);
        boolean menuLoop = true;

        while(menuLoop) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "buy":
                    coffeeMachineRobot.buy();
                    break;
                case "fill":
                    coffeeMachineRobot.fill();
                    break;
                case "take":
                    coffeeMachineRobot.takeMoney();
                    break;
                case "remaining":
                    coffeeMachineRobot.getCoffeeMachineStats();
                    break;
                case "exit":
                    menuLoop = false;
                    break;
            }
            System.out.println();
        }
    }
}
