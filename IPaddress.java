import java.util.regex.*;

public class IPaddress {
    public static boolean isValidIP(String ip) {
        String regex = "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\."
                     + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\."
                     + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\."
                     + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        return ip.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidIP("192.168.1.1"));
        System.out.println(isValidIP("256.100.50.25"));
        System.out.println(isValidIP("0.0.0.0"));
        System.out.println(isValidIP("999.999.999.999"));
    }
}
