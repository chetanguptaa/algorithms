package dp.longestCommonSubsequence;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        System.out.println(lcs("abcc", "abc", 4, 3));
    }
    public static int lcs(String a, String b, int n, int m) {
        if(n == 0 || m == 0) return 0;
        if(a.charAt(n - 1) == b.charAt(m - 1)) return 1 + lcs(a, b, n - 1, m - 1);
        else return Math.max(lcs(a, b, n - 1, m), lcs(a, b, n, m - 1));
    }
}
