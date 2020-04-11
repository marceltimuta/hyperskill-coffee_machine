package machine;

import java.util.Scanner;

public class CoffeeMachineRobot {

    private int availableWaterVolume = 400;
    private int availableMilkVolume = 540;
    private int availableCoffeeBeans = 120;
    private int availableDisposableCups = 9;
    private int availableMoney = 550;

    private Scanner scanner;

    public CoffeeMachineRobot(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getCoffeeMachineStats() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n",availableWaterVolume);
        System.out.printf("%d of milk\n",availableMilkVolume);
        System.out.printf("%d of coffee beans\n",availableCoffeeBeans);
        System.out.printf("%d of disposable cups\n",availableDisposableCups);
        System.out.printf("$%d of money\n",availableMoney);
        System.out.println();
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        addWater(scanner.nextInt());
        System.out.println("Write how many ml of milk do you want to add:");
        addMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        addCoffeeBeans(scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        addDisposableCups(scanner.nextInt());
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();

        switch (coffeeType) {
            case "1" :
                makeEspresso();
                break;
            case "2" :
                makeLatte();
                break;
            case "3" :
                makeCappuccino();
                break;
            case "back" :
                break;
        }
    }

    private void makeCappuccino() {
        if (canMakeCappuccino()) {
            System.out.println("I have enough resources, making you a coffee!");
            this.availableWaterVolume -= Coffee.CAPPUCCINO.getWater();
            this.availableMilkVolume -= Coffee.CAPPUCCINO.getMilk();
            this.availableCoffeeBeans -= Coffee.CAPPUCCINO.getBeans();
            this.availableMoney += Coffee.CAPPUCCINO.getPrice();
            this.availableDisposableCups--;
        } else {
            System.out.println("ERROR");
        }
    }

    private boolean canMakeCappuccino() {
        if(availableDisposableCups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else if (availableWaterVolume < Coffee.CAPPUCCINO.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (availableMilkVolume < Coffee.CAPPUCCINO.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (availableCoffeeBeans < Coffee.CAPPUCCINO.getBeans()) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        return true;
    }

    private void makeLatte() {
        if (canMakeLatte()) {
            System.out.println("I have enough resources, making you a coffee!");
            this.availableWaterVolume -= Coffee.LATTE.getWater();
            this.availableMilkVolume -= Coffee.LATTE.getMilk();
            this.availableCoffeeBeans -= Coffee.LATTE.getBeans();
            this.availableMoney += Coffee.LATTE.getPrice();
            this.availableDisposableCups--;
        } else {
            System.out.println("ERROR");
        }
    }

    private boolean canMakeLatte() {
        if(availableDisposableCups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else if (availableWaterVolume < Coffee.LATTE.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (availableMilkVolume < Coffee.LATTE.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (availableCoffeeBeans < Coffee.LATTE.getBeans()) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        return true;
    }

    private void makeEspresso() {
        if (canMakeEspresso()) {
            System.out.println("I have enough resources, making you a coffee!");
            this.availableWaterVolume -= Coffee.ESPRESSO.getWater();
            this.availableCoffeeBeans -= Coffee.ESPRESSO.getBeans();
            this.availableMoney += Coffee.ESPRESSO.getPrice();
            this.availableDisposableCups--;
        } else {
            System.out.println("ERROR");
        }
    }

    private boolean canMakeEspresso() {
        if(availableDisposableCups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else if (availableWaterVolume < Coffee.ESPRESSO.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (availableCoffeeBeans < Coffee.ESPRESSO.getBeans()) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        return true;
    }

    public void takeMoney() {
        System.out.printf("I gave you $%d\n",this.availableMoney);
        System.out.println();
        this.availableMoney = 0;
    }

    private void addWater(int amount) {
        this.availableWaterVolume += amount;
    }

    private void addMilk(int amount) {
        this.availableMilkVolume += amount;
    }

    private void addCoffeeBeans(int amount) {
        this.availableCoffeeBeans += amount;
    }

    private void addDisposableCups(int amount) {
        this.availableDisposableCups += amount;
    }
}
