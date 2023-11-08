package backtracking;

import java.util.Arrays;

public class MakeSquare {
    public static void main(String[] args) {
        System.out.println(makesquare(new int[] {1,1,2,2,2}));
    }
    public static boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length < 4) return false;
        int sum = 0;
        for(int matchstick: matchsticks) sum += matchstick;
        if(sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return dfs(matchsticks, new int[4], 0, sum / 4);
    }
    private static boolean dfs(int[] matchsticks, int[] sums, int index, int target) {
        if (index == matchsticks.length) {
            if(sums[0] == target && sums[1] == target && sums[2] == target) return true;
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + matchsticks[index] > target) continue;
            sums[i] += matchsticks[index];
            if (dfs(matchsticks, sums, index + 1, target)) return true;
            sums[i] -= matchsticks[index];
        }
        return false;
    }
    private static void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
