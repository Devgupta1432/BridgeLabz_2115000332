import java.util.regex.*;
import java.util.*;

public class ExtractCurr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher m = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(s);
        List<String> values = new ArrayList<>();
        while (m.find()) values.add(m.group());
        System.out.println(String.join(", ", values));
        sc.close();
    }
}
