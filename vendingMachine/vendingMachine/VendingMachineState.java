package vendingMachine;

public interface VendingMachineState {
    void selectedProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
}
