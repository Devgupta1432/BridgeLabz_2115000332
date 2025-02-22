import java.util.regex.*;
import java.util.*;

public class UVal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String u = sc.next();
        System.out.println(u.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$") ? "Valid" : "Invalid");
        sc.close();
    }
}
