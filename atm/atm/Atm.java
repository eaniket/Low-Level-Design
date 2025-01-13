package atm.atm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import atm.atm.Bank.Bank;
import atm.atm.Transaction.DepositTransaction;
import atm.atm.Transaction.Transaction;
import atm.atm.Transaction.WithdrawalTransaction;

public class Atm {
    Map<String, Bank> banks;
    CashDispenser cashDispenser;
    private static final AtomicLong TXN_COUNTER = new AtomicLong(0);

    public Atm(CashDispenser cashDispenser){
        this.cashDispenser = cashDispenser;
        banks = new HashMap<>();
    }

    public void addBank(Bank bank){
        banks.put(bank.getBankName(), bank);
    }

    public void checkBalance(Account account){
        account.getBank().checkBalance(account);
    }

    public void withdraw(Account account, Double amount){
        if(amount > cashDispenser.getCurrentAmount()){
            System.out.println("ATM has insufficient amount");
            return;
        }
        String transactionId = generateTransactionId();
        Transaction transaction = new WithdrawalTransaction(transactionId, account, amount);
        transaction.execute(account, amount);
    }

    public void deposit(Account account, Double amount){
        if(amount <= 0){
            System.out.println("Enter correct amount");
            return;
        }
        String transactionId = generateTransactionId();
        Transaction transaction = new DepositTransaction(transactionId, account, amount);
        transaction.execute(account, amount);
    }

    private String generateTransactionId(){
        long transactionNumber = TXN_COUNTER.incrementAndGet();
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    
        return "TXN_" + timeStamp + String.format("%010d", transactionNumber);
    }
}
