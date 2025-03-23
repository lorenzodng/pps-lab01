package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    public static void main(String[] args) {

        final int userId= 1;
        final int amount= 100;
        final int initialBalance= 0;
        final String name= "Mario";
        final String surname= "Rossi";
        final AccountHolder accountHolder = new AccountHolder(name, surname, userId);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, initialBalance);

        bankAccount.deposit(accountHolder.getId(), amount);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), amount);
        System.out.println("Current balance is " + bankAccount.getBalance());

    }
}
