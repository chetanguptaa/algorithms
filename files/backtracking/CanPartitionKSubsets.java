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
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return canPartition(nums, visited, 0, k, 0, 0, sum / k);
    }
    private static boolean canPartition(int[] nums, boolean[] visited, int startIndex, int k, int currSum, int currNum, int target) {
        if(k == 1) return true;
        if(currSum == target && currNum > 0) return canPartition(nums, visited, 0, k - 1, 0, 0, target);
        for(int i = startIndex; i < nums.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                if(canPartition(nums, visited, i + 1, k, currSum + nums[i], currNum++, target)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
