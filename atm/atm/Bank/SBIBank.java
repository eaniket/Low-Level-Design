package atm.atm.Bank;

import atm.atm.Account;

public class SBIBank implements Bank{
    private final String bankName = "SBI";

    public String getBankName() {
        return bankName;
    }

    @Override
    public synchronized void checkBalance(Account account) {
        //... bank's check balance logic 
        System.out.println("SBI Bank- Checking balance for account: "
            + account.getAccountNumber() + ", balance: " + account.getBalance());
    }

    @Override
    public void withdraw(Account account, Double amount) {
        if(account.getBalance() < amount){
            System.out.println("Insufficient Balance for account: " + account.getBalance());
            return;
        }
        account.updateBalance(account.getBalance() - amount);
        System.out.println("SBI Bank- withdrawn amount: " + amount +
            ", new balance: " + account.getBalance());
    }

    @Override
    public void deposit(Account account, Double amount) {
        account.updateBalance(account.getBalance() + amount);
        System.out.println("SBI Bank- deposit amount: " + amount +
            ", new balance: " + account.getBalance());
    }

}
