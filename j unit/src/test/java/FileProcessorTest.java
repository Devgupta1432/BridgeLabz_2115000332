import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

public class FileProcessorTest {
    private FileProcessor fileProcessor;
    private Path testFilePath;

    @BeforeEach
    public void setUp() throws IOException {
        fileProcessor = new FileProcessor();
        testFilePath = Files.createTempFile("testfile", ".txt");  // Creates a temp file
    }

    @Test
    public void testWriteToFile() throws IOException {
        String content = "Hello, world!";
        fileProcessor.writeToFile(testFilePath.toString(), content);
        assertTrue(Files.exists(testFilePath));  // Check if file exists
    }

    @Test
    public void testReadFromFile() throws IOException {
        String content = "Hello, world!";
        fileProcessor.writeToFile(testFilePath.toString(), content);
        String readContent = fileProcessor.readFromFile(testFilePath.toString());
        assertEquals(content, readContent);
    }

    @Test
    public void testIOException() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistentfile.txt"));
    }

    @AfterEach
    public void tearDown() {
        try {
            Files.deleteIfExists(testFilePath);  // Clean up temp file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

