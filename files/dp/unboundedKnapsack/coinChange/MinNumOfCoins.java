package dp.unboundedKnapsack.coinChange;

import java.util.Arrays;

public class MinNumOfCoins {
    public static void main(String[] args) {
        System.out.println(minNumOfCoin(new int[] {2, 5, 10, 1}, 27));
    }
    public static int minNumOfCoin(int[] coins, int sum) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 0;
        for(int i = 1; i < n + 1; i++) {
            dp[i][0] = 0;
            for(int j = 1; j < sum + 1; j++) {
                dp[0][j] = Integer.MAX_VALUE - 1;
                if(i == 1) {
                    if(j % coins[0] == 0) dp[i][j] = j / coins[0];
                    else dp[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }
        for(int i = 2; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(coins[i - 1] <= j) dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
    }
}
