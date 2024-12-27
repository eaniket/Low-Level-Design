package vendingMachine;

public class ReturnChangeState implements VendingMachineState{
    private final VendingMachine vendingMachine;
    public ReturnChangeState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectedProduct(Product product){
        System.out.println("Product already selected");
    }

    @Override
    public void insertCoin(Coin coin){
        System.out.println("Payment already submitted");
    }

    @Override
    public void insertNote(Note note){
        System.out.println("Payment already submitted");
    }

    @Override
    public void dispenseProduct(){
        System.out.println("Product already dispensed");
    }

    @Override
    public void returnChange(){
        double amountToBeReturned = vendingMachine.getTotalAmount()-vendingMachine.getSelectedProduct().getPrice();
        System.out.println("Amount to be returned: " + amountToBeReturned);
        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
