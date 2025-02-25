public class MyService {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulating a long-running task (3 seconds)
        return "Task Completed";
    }
}
