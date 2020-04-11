package machine;

public enum Coffee {

    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    final int water;
    final int milk;
    final int beans;
    final int price;

    Coffee(int water, int milk, int beans, int price) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }

    public int getWater() {
        return this.water;
    }

    public int getMilk() {
        return this.milk;
    }

    public int getBeans() {
        return this.beans;
    }

    public int getPrice() {
        return this.price;
    }
}
