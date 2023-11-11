package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindUniqueBinaryString {
    private static final List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(findUniqueBinaryString(new String[] {"00","01"}));
    }
    public static String findUniqueBinaryString(String[] nums) {
        int n = nums.length;
        findAllBinaryString(n);
        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) list.set(list.indexOf(nums[i]), "");
        }
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) != "") return list.get(i);
        }
        return "";
    }

    private static List<String> findAllBinaryString(int n) {
        helper("", 0, n);
        return list;
    }
    private static void helper(String ans, int start, int end) {
        if(start == end) {
            list.add(ans);
            return;
        }
        helper(ans + '0', start + 1, end);
        helper(ans + '1', start + 1, end);
    }
}
