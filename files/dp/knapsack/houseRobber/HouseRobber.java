package dp.knapsack.houseRobber;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {2, 1, 1, 2}));
        System.out.println(robDp(new int[] {2, 1, 1, 2}));
        System.out.println(robTab(new int[] {2, 1, 1, 2}));
    }
    public static int rob(int[] houses) {
        int n = houses.length;
        return maxProfit(houses, n - 1);
    }
    private static int maxProfit(int[] houses, int i) {
        if (i < 0) return 0;
        return Math.max(maxProfit(houses, i - 2) + houses[i], maxProfit(houses, i - 1));
    }
    public static int robDp(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxProfitDp(houses, n - 1, dp);
    }
    private static int maxProfitDp(int[] houses, int i, int[] dp) {
        if(i < 0) return 0;
        if(dp[i] != -1) return dp[i];
        dp[i] = Math.max(maxProfitDp(houses, i - 2, dp) + houses[i], maxProfitDp(houses, i - 1, dp));
        return dp[i];
    }
    public static int robTab(int[] houses) {
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
