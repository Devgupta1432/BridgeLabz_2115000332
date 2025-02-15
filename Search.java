public class Search{
    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is a popular programming language.",
            "Python is great for data science.",
            "Machine learning is fascinating.",
            "This is a Java tutorial."
        };

        String targetWord = "Java";
        String result = findSentenceWithWord(sentences, targetWord);

        System.out.println("Sentence containing '" + targetWord + "': " + result);
    }
}
