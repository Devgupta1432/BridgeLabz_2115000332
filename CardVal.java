import java.util.*;

public class CardVal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String card = sc.next();
        if (card.matches("^4\\d{15}$")) {
            System.out.println("Valid Visa");
        } else if (card.matches("^5\\d{15}$")) {
            System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid");
        }
        sc.close();
    }
}
