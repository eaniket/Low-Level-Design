package vendingMachine;

public class ReadyState implements VendingMachineState{
    private final VendingMachine vendingMachine;
    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectedProduct(Product product){
        System.out.println("Product already selected");
    }
    
    @Override
    public void insertCoin(Coin coin){
        vendingMachine.addCoin(coin);
        checkStatus();
    }

    @Override
    public void insertNote(Note note){
        vendingMachine.addNote(note);
        checkStatus();
    }

    @Override
    public void dispenseProduct(){
        System.out.println("Please make the payment");
    }

    @Override
    public void returnChange(){
        System.out.println("No change to return");
    }

    private void checkStatus(){
        if(vendingMachine.getTotalAmount() >= vendingMachine.getSelectedProduct().getPrice()){
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }
}
