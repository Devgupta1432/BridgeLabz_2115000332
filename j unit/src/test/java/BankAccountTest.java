package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        BankAccount account = new BankAccount(100);
        assertTrue(account.withdraw(50));
        assertEquals(50, account.getBalance());
    }

    @Test
    void testWithdrawFailure() {
        BankAccount account = new BankAccount(100);
        assertFalse(account.withdraw(150));
        assertEquals(100, account.getBalance());
    }
}
