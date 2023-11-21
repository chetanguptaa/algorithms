package dp.knapsack;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairsRecursive(new int[] {1, 2, 9, 4, 2}));
        System.out.println(minCostClimbingStairs(new int[] {1, 2, 9, 4, 2}));
        System.out.println(minCostClimbingStairsTab(new int[] {1, 2, 9, 4, 2}));
    }
    public static int minCostClimbingStairsRecursive(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }
    private static int minCost(int[] cost, int n) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return cost[n];
        return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        return Math.min(minCostDp(cost, n - 1, dp), minCostDp(cost, n - 2, dp));
    }
    private static int minCostDp(int[] cost, int n, int[] dp) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return cost[n];
        if(dp[n] != 0) return dp[n];
        dp[n] = cost[n] + Math.min(minCostDp(cost, n - 1, dp), minCostDp(cost, n - 2, dp));
        return dp[n];
    }
    public static int minCostClimbingStairsTab(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            if(i < 2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
