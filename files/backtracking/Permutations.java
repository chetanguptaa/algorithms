package backtracking;

import java.util.*;
public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[] {1, 2, 3}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        if(tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
        else {
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
