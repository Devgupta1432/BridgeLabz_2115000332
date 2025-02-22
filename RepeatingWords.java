import java.util.regex.*;
import java.util.*;

public class RepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b(?=.*\\b\\1\\b)");
        Matcher matcher = pattern.matcher(text);
        Set<String> repeatedWords = new HashSet<>();
        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }
        System.out.println(String.join(", ", repeatedWords));
    }
}
