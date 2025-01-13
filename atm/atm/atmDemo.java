package atm.atm;

import atm.atm.Bank.Bank;
import atm.atm.Bank.HDFCBank;
import atm.atm.Bank.SBIBank;

public class atmDemo {
    public static void run(){
        Bank bank1 = new SBIBank();
        Bank bank2 = new HDFCBank();

        CashDispenser cashDispenser = new CashDispenser(10000.0);

        Atm atm = new Atm(cashDispenser);
        atm.addBank(bank1);
        atm.addBank(bank2);

        Account account = new Account(bank1, "432586394", "2354", 500.0);

        atm.checkBalance(account);
        atm.withdraw(account, 60000.0);
        atm.withdraw(account, 600.0);
        atm.deposit(account, 100.0);
        atm.withdraw(account, 500.0);
        atm.checkBalance(account);
    }
    public static void main(String[] args) {
        run();
    }
}
