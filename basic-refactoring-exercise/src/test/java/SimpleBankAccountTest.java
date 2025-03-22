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
    private int amount= 100;

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
