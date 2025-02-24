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
    private int userId=1;
    private double balance;
    private double amount;
    private double expectedAmount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", userId);

        balance= 0;
        bankAccount = new SimpleBankAccount(accountHolder, balance);
    }

    @Test
    void testInitialBalance() {
        expectedAmount= 0;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        amount= 100;
        bankAccount.deposit(accountHolder.getId(), amount);

        expectedAmount= 100;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        amount= 100;
        bankAccount.deposit(accountHolder.getId(), amount);

        userId= 2;
        amount= 50;
        bankAccount.deposit(userId, amount);

        expectedAmount= 100;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        amount= 100;
        bankAccount.deposit(accountHolder.getId(), amount);

        amount= 70;
        bankAccount.withdraw(accountHolder.getId(), amount);

        expectedAmount= 30;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        amount= 100;
        bankAccount.deposit(accountHolder.getId(), amount);

        int userId= 2;
        amount= 70;
        bankAccount.withdraw(userId, amount);

        expectedAmount= 100;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

    @Test
    void TestWithdrawWithFee(){
        amount= 100;
        bankAccount.deposit(accountHolder.getId(), amount);

        amount= 70;
        bankAccount.withdraw(accountHolder.getId(), amount);

        expectedAmount= 29;
        assertEquals(expectedAmount, bankAccount.getBalance());
    }

}
