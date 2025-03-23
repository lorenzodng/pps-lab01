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

    @BeforeEach
    void beforeEach(){
        String name= "Mario";
        String surname= "Rossi";
        int userId= 1;
        accountHolder = new AccountHolder(name, surname, userId);
        int initialBalance= 0;
        bankAccount = new SimpleBankAccount(accountHolder, initialBalance);
    }

    @Test
    void testInitialBalance() {
        int expectedAmount= 0;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT);
        int expectedAmount= 100;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int wrongUserId= 2;
        bankAccount.deposit(wrongUserId, AMOUNT);
        int expectedAmount= 0;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), AMOUNT);
        int expectedAmount= 100;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT);
        int wrongUserId= 2;
        bankAccount.withdraw(wrongUserId, AMOUNT);
        int expectedAmount= 100;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithFee(){
        bankAccount.deposit(accountHolder.getId(), AMOUNT);
        int amountWithFee= 99;
        bankAccount.withdraw(accountHolder.getId(), amountWithFee);
        int expectedAmount= 0;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }
}
