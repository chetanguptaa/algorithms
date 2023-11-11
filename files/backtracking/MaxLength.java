package backtracking;

// Max Length of concatenated strings with unique characters

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLength {
    public static void main(String[] args) {
        System.out.println(maxLength(Arrays.asList("un","iq","ue")));
    }
    public static int maxLength(List<String> arr) {
        return backtrack(arr, "", 0);
    }
    private static int backtrack(List<String> arr, String str, int idx) {
        if(!allUniqueChars(str)) return 0;
        int maxLength = str.length();
        for (int i = idx; i < arr.size(); i++) {
            int newLength = backtrack(arr, str + arr.get(i), i + 1);
            maxLength = Math.max(maxLength, newLength);
        }
        return maxLength;
    }
    private static boolean allUniqueChars(String str) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            if(set.contains(str.charAt(i))) return false;
            set.add(str.charAt(i));
        }
        return true;
    }
}
