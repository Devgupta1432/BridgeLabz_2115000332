public class DatabaseConnection {
    private boolean isConnected = false;

    public void connect() {
        isConnected = true;
        System.out.println("Connected to the database");
    }

    public void disconnect() {
        isConnected = false;
        System.out.println("Disconnected from the database");
    }

    public boolean isConnected() {
        return isConnected;
    }
}
