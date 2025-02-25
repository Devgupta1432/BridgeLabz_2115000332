import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MyServiceTest {
    private final MyService myService = new MyService();

    @Timeout(5) // Increases timeout to 5 seconds
    @Test
    void testLongRunningTask() {
        try {
            myService.longRunningTask();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            fail("Test was interrupted");
        }
    }
}
