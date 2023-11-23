package dp.longestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        System.out.println(lcs("abcc", "abc", 4, 3));
        System.out.println(lcsDp("abcc", "abc", 4, 3));
        System.out.println(lcsTab("abcccc", "abccc", 6, 5));
    }
    public static int lcs(String a, String b, int n, int m) {
        if(n == 0 || m == 0) return 0;
        if(a.charAt(n - 1) == b.charAt(m - 1)) return 1 + lcs(a, b, n - 1, m - 1);
        else return Math.max(lcs(a, b, n - 1, m), lcs(a, b, n, m - 1));
    }
    public static int lcsDp(String a, String b, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for(int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return lcsDpHelper(a, b, n, m, dp);
    }
    private static int lcsDpHelper(String a, String b, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            dp[n][m] = 1 + lcsDpHelper(a, b, n - 1, m - 1, dp);
            return dp[n][m];
        }
        dp[n][m] = Math.max(lcsDpHelper(a, b, n - 1, m, dp), lcsDpHelper(a, b, n, m - 1, dp));
        return dp[n][m];
    }
    public static int lcsTab(String a, String b, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
            for(int j = 0; j < m + 1; j++) {
                dp[0][j] = 0;
            }
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}
