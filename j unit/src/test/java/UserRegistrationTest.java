package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class UserRegistrationTest {
    UserRegistration registration;

    @BeforeEach
    public void setUp() {
        registration = new UserRegistration();
    }

    @Test
    public void testRegisterValidUser() {
        assertDoesNotThrow(() -> registration.registerUser("user", "user@example.com", "password123"));
    }

    @Test
    public void testRegisterInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("", "user@example.com", "password123"));
    }

    @Test
    public void testRegisterInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("user", "invalid_email", "password123"));
    }

    @Test
    public void testRegisterInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("user", "user@example.com", "short"));
    }
}
