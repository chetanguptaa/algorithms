import java.util.*;
public class Leetcode {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[] {5,-3,5}));
    }
    static int maxSubarraySumCircular(int[] nums) {
        int[] table = new int[nums.length];
        table[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(i == nums.length - 1) {
                table[(i + 1) % nums.length] = nums[(i + 1) % nums.length] + (nums[(i) % nums.length] > 0 ? nums[(i + 1) % nums.length] : 0);
            }
            table[i] = nums[i] + (nums[i - 1] > 0 ? nums[i] : 0);
            max = Math.max(max, table[i]);
        }
        return max;
    }
}

