package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindromePartitioning("aab"));
    }
    public static List<List<String>> palindromePartitioning(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s);
        return list;
    }
    private static void backtrack(List<List<String>> list, List<String> tempList, String s) {
        if(s == null || s.length() == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue;
            tempList.add(temp);
            backtrack(list, tempList, s.substring(i, s.length()));
            tempList.remove(tempList.size() - 1);
        }
        return;
    }
    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
