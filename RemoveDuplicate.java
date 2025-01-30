public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            boolean isDuplicate = false;

            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == currentChar) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                result += currentChar;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "programming";
        System.out.println("Original: " + str);
        System.out.println("Without Duplicates: " + removeDuplicates(str));
    }
}
