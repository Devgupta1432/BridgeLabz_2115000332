import java.util.regex.*;
import java.util.*;

public class LangExtract {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        Pattern pattern = Pattern.compile("\\b(JavaScript|Java|Python|Go)\\b");
        Matcher matcher = pattern.matcher(text);
        List<String> languages = new ArrayList<>();
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        System.out.println(String.join(", ", languages));
    }
}
