package dp.longestCommonSubsequence;

public class LCSubString {
    public static void main(String[] args) {
        System.out.println(lcs("abc", "abcc", 3, 4));
    }
    public static int lcs(String a, String b, int n, int m) {
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
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else dp[i][j] = 0;
            }
        }
        int ans = 0;
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < m + 1; j++) ans = Math.max(ans, dp[i][j]);
        }
        return ans;
    }
}
