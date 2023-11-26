package dp.longestCommonSubsequence;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubString("aacabdkacaa"));
    }
    public static String longestPalindromeSubString(String s) {
        if(s.length() == 1) return s;
        String sRev = rev(s);
        int n = s.length(), m = s.length();
        return longestPalindromeSubString(s, sRev, n, m);
    }
    private static String longestPalindromeSubString(String a, String b, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
            for(int j = 0; j < m + 1; j++) dp[0][j] = 0;
        }
        int maxLength = 0, start = 0;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    int rIdx = i;
                    int idx = j - dp[i][j] + 1;
                    if(n - rIdx + 1 == idx) {
                        if(maxLength < dp[i][j]){
                            maxLength = dp[i][j];
                            start = i;
                        }
                    }
                } else dp[i][j] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(maxLength > 0) {
            sb.append(a.charAt(start - 1));
            start--;
            maxLength--;
        }
        return sb.toString();
    }
    private static String rev(String a) {
        return new StringBuilder(a).reverse().toString();
    }
}
