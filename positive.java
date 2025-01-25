import java.util.Scanner;
public class positive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] > 0) System.out.println(nums[i] + (nums[i] % 2 == 0 ? " is even" : " is odd"));
            else if (nums[i] < 0) System.out.println(nums[i] + " is negative");
            else System.out.println(nums[i] + " is zero");
        }
        System.out.println(nums[0] == nums[4] ? "First and last are equal" : nums[0] > nums[4] ? "First is greater" : "Last is greater");
    }
}
