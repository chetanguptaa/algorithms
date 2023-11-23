package dp.longestCommonSubsequence;

public class PrintLCSubSequence {
    public static void main(String[] args) {
        printLCS("abcc", "abcc", 4, 4);
    }
    public static void printLCS(String a, String b, int n, int m) {
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
        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        while(i > 0 || j > 0) {
            if(a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if(dp[i - 1][j] > dp[i][j - 1]) i--;
                else j--;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
