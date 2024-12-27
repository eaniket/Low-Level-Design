package vendingMachine;

public class VendingMachineDemo {
    public static void main(String args[]){
        VendingMachine vendingMachine = VendingMachine.getInstance();

        //Add products
        Product pepsi = new Product("Pepsi", 1.5);
        Product coke = new Product("Coke", 1.5);
        Product water = new Product("Water", 1.0);

        vendingMachine.inventory.addProduct(coke, 5);
        vendingMachine.inventory.addProduct(pepsi, 3);
        vendingMachine.inventory.addProduct(water, 7);


        //Select a product
        vendingMachine.selectedProduct(coke);

        //Payment
        vendingMachine.insertCoin(Coin.QUATER);
        vendingMachine.insertCoin(Coin.QUATER);
        vendingMachine.insertCoin(Coin.QUATER);
        vendingMachine.insertCoin(Coin.QUATER);

        vendingMachine.insertNote(Note.FIVE);

        //Dispense the product
        vendingMachine.dispenseProduct();

        //Return the change
        vendingMachine.returnChange();

        //Select a product
        vendingMachine.selectedProduct(pepsi);

        //Payment
        vendingMachine.insertCoin(Coin.QUATER);

        //Attempt to dispense the product
        vendingMachine.dispenseProduct();

        vendingMachine.insertCoin(Coin.QUATER);
        vendingMachine.insertCoin(Coin.QUATER);
        vendingMachine.insertCoin(Coin.QUATER);
        vendingMachine.insertCoin(Coin.QUATER);

        //Dispense the product
        vendingMachine.dispenseProduct();

        //Return the change
        vendingMachine.returnChange();
    }
}
