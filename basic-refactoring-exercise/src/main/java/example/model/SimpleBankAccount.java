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

    public SimpleBankAccount(final AccountHolder HOLDER, final double balance) {
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
    public void deposit(final int USERID, final double AMOUNT) {
        if (checkUser(USERID)) {
            this.balance += AMOUNT;
        }
    }

    @Override
    public void withdraw(final int USERID, final double AMOUNT) {
        if (checkUser(USERID) && isWithdrawAllowed(AMOUNT)) {
            this.balance = this.balance - AMOUNT - FEE;
        }
    }

    private boolean isWithdrawAllowed(final double AMOUNT){
        return this.balance >= AMOUNT;
    }

    private boolean checkUser(final int ID) {
        return this.HOLDER.getID() == ID;
    }
}
