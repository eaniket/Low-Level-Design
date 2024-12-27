package coffeeVendingMachine.coffeeVendingMachine;


public class CoffeeVendingMachineDemo {
    public static void run(){
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

        coffeeMachine.displayMenu();
        Coffee espresso = coffeeMachine.selectCoffee("Espresso");
        coffeeMachine.dispenseCoffee(espresso, new Payment(4.0));
    }

    public static void main(String[] args) {
        run();
    }
}
