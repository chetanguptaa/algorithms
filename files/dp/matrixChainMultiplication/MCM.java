package dp.matrixChainMultiplication;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        System.out.println(mcm(new int[] {40, 20, 30, 10, 30}));
        System.out.println(mcmDP(new int[] {40, 20, 30, 10, 30}));
    }
    public static int mcm(int[] arr) {
        int n = arr.length;
        return mcm(arr, 1, n - 1);
    }
    private static int mcm(int[] arr, int i, int j) {
        if(i >= j) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int tempRes = mcm(arr, i, k) + mcm(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            ans = Math.min(ans, tempRes);
        }
        return ans;
    }
    public static int mcmDP(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[1001][1001]; // Consider the constraints are 1000
        for(int[] a: dp) Arrays.fill(a, -1);
        return mcmDP(arr, 1, n - 1, dp);
    }
    private static int mcmDP(int[] arr, int i, int j, int[][] dp) {
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int tempRes = mcmDP(arr, i, k, dp) + mcmDP(arr, k + 1, j, dp) + (arr[i - 1] * arr[k] * arr[j]);
            ans = Math.min(ans, tempRes);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}
