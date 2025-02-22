import java.util.*;

public class CensorWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] badWords = {"damn", "stupid"};
        for (String word : badWords) {
            s = s.replaceAll("\\b" + word + "\\b", "****");
        }
        System.out.println(s);
        sc.close();
    }
}
