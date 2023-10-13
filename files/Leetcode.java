import java.util.*;

public class Leetcode {
    public static void main(String[] args) {
        System.out.println();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 4)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int k = j + 1, l = len - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        if (!ans.contains(temp))
                            ans.add(temp);
                        k++;
                        l--;
                    } else if (sum > target)
                        l--;
                    else
                        k++;
                }
            }
        }
        return ans;
    }
}