import java.util.regex.*;
import java.util.*;

public class LinkExtract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher m = Pattern.compile("https?://\\S+").matcher(s);
        List<String> links = new ArrayList<>();
        while (m.find()) links.add(m.group());
        System.out.println(String.join(", ", links));
        sc.close();
    }
}
