package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private final AccountHolder HOLDER;
    private double balance;
    private static final int FEE= 1;

    public SimpleBankAccount(final AccountHolder HOLDER, double balance) {
        this.HOLDER = HOLDER;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHOLDER(){
        return this.HOLDER;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int USERID, double amount) {
        if (checkUser(USERID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int USERID, double amount) {
        if (checkUser(USERID) && isWithdrawAllowed(amount)) {
            this.balance = this.balance - amount - FEE;
        }
    }

    private boolean isWithdrawAllowed(double amount){
        return this.balance >= amount;
    }

    private boolean checkUser(final int ID) {
        return this.HOLDER.getID() == ID;
    }
}
