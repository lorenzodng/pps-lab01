import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private static final String NAME= "Mario";
    private static final String SURNAME= "Rossi";
    private static final int INITIAL_BALANCE= 0;
    private static final int USER_ID= 1;
    private int amount= 100;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder(NAME, SURNAME, USER_ID);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        int expectedAmount= 0;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getID(), amount);
        int expectedAmount= 100;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int wrongUserId= 2;
        bankAccount.deposit(wrongUserId, amount);
        int expectedAmount= 0;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getID(), amount);
        bankAccount.withdraw(accountHolder.getID(), amount);
        int expectedAmount= 100;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getID(), amount);
        int wrongUserId= 2;
        bankAccount.withdraw(wrongUserId, amount);
        int expectedAmount= 100;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithFee(){
        bankAccount.deposit(accountHolder.getID(), amount);
        int amountWithFee= 99;
        bankAccount.withdraw(accountHolder.getID(), amountWithFee);
        int expectedAmount= 0;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }
}
