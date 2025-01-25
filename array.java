import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Error");
            return;
        }
        int[] odd = new int[n / 2 + 1], even = new int[n / 2 + 1];
        int oIndex = 0, eIndex = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) even[eIndex++] = i;
            else odd[oIndex++] = i;
        }
        for (int i = 0; i < oIndex; i++) System.out.print(odd[i] + " ");
        System.out.println();
        for (int i = 0; i < eIndex; i++) System.out.print(even[i] + " ");
    }
}
