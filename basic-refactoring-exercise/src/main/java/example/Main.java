package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    public static void main(String[] args) {

        int userId= 1;
        final double AMOUNT= 100;
        double balance= 0;
        String name= "Mario";
        String surname= "Rossi";

        final AccountHolder accountHolder = new AccountHolder(name, surname, userId);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, balance);
        bankAccount.deposit(accountHolder.getID(), AMOUNT);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getID(), AMOUNT);
        System.out.println("Current balance is " + bankAccount.getBalance());

    }
}
