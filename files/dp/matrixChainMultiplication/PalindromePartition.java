package dp.matrixChainMultiplication;

import java.util.Arrays;

public class PalindromePartition {
    public static void main(String[] args) {
        System.out.println(palindromePart("racecare"));
        System.out.println(palindromePartDP("tool"));
    }
    public static int palindromePart(String s) {
        int n = s.length();
        return palindromePart(s, 0, n - 1);
    }
    private static int palindromePart(String s, int i, int j) {
        if(i >= j) return 0;
        if(isPalindrome(s, i, j)) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int tempRes = palindromePart(s, i, k) + palindromePart(s, k + 1, j) + 1;
            ans = Math.min(ans, tempRes);
        }
        return ans;
    }
    private static boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static int palindromePartDP(String s) {
        int n = s.length();
        int[][] dp = new int[1001][1001];
        for(int[] a: dp) Arrays.fill(a, -1);
        return palindromePartDP(s, 0, n - 1, dp);
    }
    private static int palindromePartDP(String s, int i, int j, int[][] dp) {
        if(i >= j) return 0;
        if(isPalindrome(s, i, j)) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int tempRes = palindromePart(s, i, k) + palindromePart(s, k + 1, j) + 1;
            ans = Math.min(ans, tempRes);
            dp[i][j] = ans;
        }
        return dp[i][j];
    }
}
