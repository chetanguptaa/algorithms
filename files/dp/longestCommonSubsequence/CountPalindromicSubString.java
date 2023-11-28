package dp.longestCommonSubsequence;

public class CountPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for(int d = 0; d < n; d++) {
            for(int i = 0; i < n - d; i++) {
                int j = i + d;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i + 1 >= j - 1 || dp[i + 1][j - 1];
                    if (dp[i][j]) count++;
                }
            }
        }
        return count;
    }
}
