package dp.longestCommonSubsequence;

// Basically to find the shortest string for which string a and b are a subsequence

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        System.out.println(scs("geek", "eek", 4, 3));
    }
    public static int scs(String a, String b, int n, int m) {
        return a.length() + b.length() - lcs(a, b, n, m);
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
