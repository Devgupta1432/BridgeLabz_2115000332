import java.lang.reflect.*;

class TimeTracker {
    public void process() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Processing...");
    }
}

class MethodTimer {
    public static void measureTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();
        System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void main(String[] args) throws Exception {
        TimeTracker tracker = new TimeTracker();
        measureTime(tracker, "process");
    }
}
