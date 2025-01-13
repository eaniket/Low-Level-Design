package atm.atm.Bank;

import atm.atm.Account;

public interface Bank {
    public String getBankName();
    public void checkBalance(Account account);
    public void withdraw(Account account, Double amount);
    public void deposit(Account account, Double amount);
}
