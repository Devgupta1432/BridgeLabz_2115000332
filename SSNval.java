import java.util.regex.*;
import java.util.*;

public class SSNval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher m = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b").matcher(s);
        if (m.find()) {
            System.out.println(m.group() + " is valid");
        } else {
            System.out.println("Invalid");
        }
        sc.close();
    }
}
