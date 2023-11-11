package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindAllBinaryString {
    private static final List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(findAllBinaryStrings(5));
    }

    public static List<String> findAllBinaryStrings(int n) {
        helper("", 0, n);
        return list;
    }
    public static void helper(String ans, int start, int end) {
        if(start == end) {
            list.add(ans);
            return;
        }
        helper(ans + '0', start + 1, end);
        helper(ans + '1', start + 1, end);
    }
}
