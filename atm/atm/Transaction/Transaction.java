package atm.atm.Transaction;

import atm.atm.Account;

public abstract class Transaction {

    private final String transactionId;
    private final Account account;
    private final Double amount;

    public Transaction(String transactionId, Account account, Double amount){
        this.transactionId = transactionId;
        this.account = account;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public abstract void execute(Account account, Double amount);
}
