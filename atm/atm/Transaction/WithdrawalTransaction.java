package atm.atm.Transaction;

import atm.atm.Account;

public class WithdrawalTransaction extends Transaction{

    public WithdrawalTransaction(String transactionId, Account account, Double amount){
        super(transactionId, account, amount);
    }

    @Override
    public void execute(Account account, Double amount) {
        System.out.println("Executing transaction: " + getTransactionId());
        account.getBank().withdraw(account, amount);
    }

}
