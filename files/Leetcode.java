import java.util.*;
public class Leetcode {
    public static void main(String[] args) {
        System.out.println(findMatrix(new int[] {1,3,4,1,2,3,1}));
    }
    static List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        while(!map.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i : map.keySet()) {
                temp.add(i);
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) map.remove(i);
            }
            ans.add(temp);
        }
        return ans;
    }
}

