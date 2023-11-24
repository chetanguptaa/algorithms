package dp.longestCommonSubsequence;

import java.util.Arrays;

public class MiniNumOfInsAndDel {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(miniNumOfInsAndDel("heap", "pea")));
    }
    public static int[] miniNumOfInsAndDel(String a, String b) {
        int n = a.length(), m = b.length();
        int ans = lcs(a, b, n, m);
        return new int[] {a.length() - ans, b.length() - ans};
    }
    private static int lcs(String a, String b, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
            for(int j = 0; j < m + 1; j++) dp[0][j] = 0;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}
