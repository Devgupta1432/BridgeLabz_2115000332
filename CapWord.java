import java.util.regex.*;
import java.util.*;

public class CapWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher m = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(s);
        List<String> words = new ArrayList<>();
        while (m.find()) words.add(m.group());
        System.out.println(String.join(", ", words));
        sc.close();
    }
}
