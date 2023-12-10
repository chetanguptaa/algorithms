package dp.longestCommonSubsequence;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++)
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
        }
        int ans = Integer.MIN_VALUE;
        for(int a: dp) ans = Math.max(ans, a);
        return ans;
    }
}
