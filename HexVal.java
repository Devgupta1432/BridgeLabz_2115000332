import java.util.regex.*;
import java.util.*;

public class HexVal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String h = sc.next();
        System.out.println(h.matches("^#[a-fA-F0-9]{6}$") ? "Valid" : "Invalid");
        sc.close();
    }
}
