package coffeeVendingMachine.coffeeVendingMachine;

public class Ingredient {
    private String name;
    private int qty;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    public void updateQty(int value){
        this.qty += value;
    }

    public Ingredient(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }
}
