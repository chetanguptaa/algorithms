package backtracking;

import java.util.Arrays;

public class CanPartitionKSubsets {
    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[] {4,3,2,3,5,2,1}, 4));
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(k <= 0 || sum % k != 0) return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum/k);
    }
    private static boolean canPartition(int[] nums, int[] visited, int startIndex, int k, int currSum, int currNum, int target) {
        if(k == 1) return true;
        if(currSum == target && currNum > 0) return true;
        return false;
    }
}
