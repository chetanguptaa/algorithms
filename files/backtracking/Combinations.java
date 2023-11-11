package backtracking;

import java.util.List;
import java.util.ArrayList;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, k, 1);
        return list;
    }
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int n, int k, int start) {
        if(tempList.size() == k) list.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i <= n; i++) {
                tempList.add(i);
                backtrack(list, tempList, n, k, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
