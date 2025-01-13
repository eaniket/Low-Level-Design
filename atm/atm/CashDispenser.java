package atm.atm;

public class CashDispenser {
    private Double currentAmount;

    public CashDispenser(Double amount){
        this.currentAmount = amount;
    }

    public Double getCurrentAmount(){
        return currentAmount;
    }

    public void addAmount(Double amount){
        if(amount > 0){
            currentAmount += amount;
        }
    }
}
