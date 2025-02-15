public class ConcatneateStrings {
    public static String concatenate(String[] strings) {
        StringBuffer sb = new StringBuffer();

        for (String str : strings) {
            sb.append(str);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!", " Welcome", " to", " Java."};
        String result = concatenate(words);
        System.out.println("Concatenated string: " + result);
    }
}
