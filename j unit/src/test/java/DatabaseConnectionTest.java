import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {
    private DatabaseConnection databaseConnection;

    @BeforeEach
    public void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    public void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    public void testConnection() {
        assertTrue(databaseConnection.isConnected(), "Database should be connected");
    }
}
