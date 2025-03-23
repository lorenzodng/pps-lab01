package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private final AccountHolder holder;
    private int balance;
    private static final int FEE= 1;

    public SimpleBankAccount(final AccountHolder holder, int balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userId, int amount) {
        if (checkUser(userId)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userId, int amount) {
        if (checkUser(userId) && isWithdrawAllowed(amount)) {
            this.balance = this.balance - amount - FEE;
        }
    }

    private boolean isWithdrawAllowed(double amount){
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
