import java.util.*;

class House_robber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter money in each house:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int ans = rob(nums);
        System.out.println("Maximum money that can be robbed = " + ans);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = 0;        // dp[i-2]
        int prev1 = nums[0]; // dp[i-1]

        for (int i = 1; i < n; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
