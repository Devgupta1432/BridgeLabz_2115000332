package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DateFormatterTest {
    DateFormatter formatter;

    @BeforeEach
    public void setUp() {
        formatter = new DateFormatter();
    }

    @Test
    public void testFormatDateValid() {
        assertEquals("22-02-2025", formatter.formatDate("2025-02-22"));
    }

    @Test
    public void testFormatDateInvalid() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("22-02-2025"));
    }
}
