package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    public static void main(String[] args) {

        double amount;

        int userId= 1;
        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", userId);
        double balance= 0;
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, balance);

        amount= 100;
        bankAccount.deposit(accountHolder.getId(), amount);
        System.out.println("Current balance is " + bankAccount.getBalance());

        amount= 30;
        bankAccount.withdraw(accountHolder.getId(), amount);
        System.out.println("Current balance is " + bankAccount.getBalance());

        amount= 80;
        bankAccount.withdraw(accountHolder.getId(), amount);
        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
