package dp.knapsack.houseRobber;

public class HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1, 2, 2, 4}));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];
        a[0] = nums[0];
        for(int i = 1; i < n - 1; i++) {
            a[i] = nums[i];
            b[i - 1] = nums[i];
        }
        b[n - 2] = nums[n - 1];
        return Math.max(robTab(a), robTab(b));
    }
    private static int robTab(int[] houses) {
        if (houses.length == 0) return 0;
        int[] dp = new int[houses.length + 1];
        dp[0] = 0;
        dp[1] = houses[0];
        for (int i = 1; i < houses.length; i++) {
            int val = houses[i];
            dp[i+1] = Math.max(dp[i], dp[i-1] + val);
        }
        return dp[houses.length];
    }
}
