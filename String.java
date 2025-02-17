public class String {

    public static void concatString(int N) {
        String str = "";
        for (int i = 0; i < N; i++) str += "a";
    }

    public static void concatStringBuilder(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append("a");
    }

    public static void concatStringBuffer(int N) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) sb.append("a");
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int N : sizes) {
            long start = System.nanoTime();
            concatString(N);
            System.out.println("String: " + (System.nanoTime() - start) / 1e6 + "ms");

            start = System.nanoTime();
            concatStringBuilder(N);
            System.out.println("StringBuilder: " + (System.nanoTime() - start) / 1e6 + "ms");

            start = System.nanoTime();
            concatStringBuffer(N);
            System.out.println("StringBuffer: " + (System.nanoTime() - start) / 1e6 + "ms");
        }
    }
}
