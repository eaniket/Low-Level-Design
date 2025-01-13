package atm.atm;

import atm.atm.Bank.Bank;

public class Account {
    private final Bank bank;
    private final String accountNumber;
    private final String pin;
    private Double balance;

    public Account(Bank bank, String accountNumber, String pin, Double balance) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public Double getBalance() {
        return balance;
    }

    public void updateBalance(Double balance) {
        this.balance = balance;
    }
}
