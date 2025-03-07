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
    private static final int AMOUNT= 100;
    private static final int MIN_EXPECTED_AMOUNT= 0;
    private static final int MAX_EXPECTED_AMOUNT= 100;
    private static final String NAME= "Mario";
    private static final String SURNAME= "Rossi";

    @BeforeEach
    void beforeEach(){
        int userId= 1;
        accountHolder = new AccountHolder(NAME, SURNAME, userId);
        int balance= 0;
        bankAccount = new SimpleBankAccount(accountHolder, balance);
    }

    @Test
    void testInitialBalance() {
        assertEquals(MIN_EXPECTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getID(), AMOUNT);
        assertEquals(MAX_EXPECTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int wrongUserId= 2;
        bankAccount.deposit(wrongUserId, AMOUNT);
        assertEquals(MIN_EXPECTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getID(), AMOUNT);
        bankAccount.withdraw(accountHolder.getID(), AMOUNT);
        assertEquals(MAX_EXPECTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getID(), AMOUNT);
        int wrongUserId= 2;
        bankAccount.withdraw(wrongUserId, AMOUNT);
        assertEquals(MAX_EXPECTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithFee(){
        bankAccount.deposit(accountHolder.getID(), AMOUNT);
        int amountWithFee= 99;
        bankAccount.withdraw(accountHolder.getID(), amountWithFee);
        assertEquals(MIN_EXPECTED_AMOUNT, bankAccount.getBalance());
    }
}
