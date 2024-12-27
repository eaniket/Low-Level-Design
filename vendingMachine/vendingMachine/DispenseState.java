package vendingMachine;

public class DispenseState implements VendingMachineState{
    private final VendingMachine vendingMachine;
    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

     @Override
     public void selectedProduct(Product product){
        System.out.println("Product already selected, dispensing product");
     }

     @Override
     public void insertCoin(Coin coin){
        System.out.println("Coins already added, dispensing product");
     }

     @Override
     public void insertNote(Note note){
        System.out.println("Note already added, dispensing product");
     }

     @Override
     public void dispenseProduct(){
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(product, vendingMachine.inventory.getQuantity(product) - 1);
        System.out.println("Product dispensed: " + product.getName());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
     }

     @Override
     public void returnChange(){
        System.out.println("Please collect the dispensed product");
     }
}
