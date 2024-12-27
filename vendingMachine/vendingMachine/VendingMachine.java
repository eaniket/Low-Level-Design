package vendingMachine;

public class VendingMachine {
    private static VendingMachine instance;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private double totalAmount;
    Inventory inventory;

    private VendingMachine(){
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        totalAmount = 0.0;
    }

    public static synchronized VendingMachine getInstance(){
        if(instance == null){
            instance = new VendingMachine();
        }
        return instance;
    }

    public void selectedProduct(Product product){
        currentState.selectedProduct(product);
    }

    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note){
        currentState.insertNote(note);
    }

    public void dispenseProduct(){
        currentState.dispenseProduct();
    }

    public void returnChange(){
        currentState.returnChange();
    }

    void setState(VendingMachineState state){
        currentState = state;
    }

    VendingMachineState getIdleState(){
        return idleState;
    }

    VendingMachineState getReadyState(){
        return readyState;
    }

    VendingMachineState getDispenseState(){
        return dispenseState;
    }

    VendingMachineState getReturnChangeState(){
        return returnChangeState;
    }
    
    Product getSelectedProduct(){
        return selectedProduct;
    }

    void setSelectedProduct(Product product){
        selectedProduct = product;
    }

    void resetSelectedProduct(){
        selectedProduct = null;
    }

    double getTotalAmount(){
        return totalAmount;
    }

    void addCoin(Coin coin){
        totalAmount += coin.getValue();
    }

    void addNote(Note note){
        totalAmount += note.getValue();
    }

    void resetAmount(){
        totalAmount = 0.0;
    }

}
