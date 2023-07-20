package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgrammingTab {
    public static void main(String[] args) {
//        System.out.println(fib(5));
//        System.out.println(gridTraveller(3, 3));
//        System.out.println(canSum(7, new int[] {4,3,1}));
//        System.out.println(howSum(57, new int[] {2,2,2}));
//        System.out.println(bestSum(7, new int[] {4,3,1}));
//        System.out.println(canConstruct("abc", new String[] {"abc"}));
//        System.out.println(countConstruct("abc", new String[] {"abc"}));
        System.out.println(allConstruct("abc", new String[] {"abc", "a", "b", "c", "bc", "ac", "ab"}));
    }
    static int fib(int n) {
        int[] table = new int[n + 1];
        for(int num: table) num = 0;
        table[1] = 1;
        for (int i = 0; i < n; i++) {
            if(i == n - 1) table[i + 1] += table[i];
            else {
                table[i + 1] += table[i];
                table[i + 2] += table[i];
            }
        }
        return table[n];
    }
    static int gridTraveller(int row, int col) {
        int[][] table = new int[row + 1][col + 1];
        table[1][1] = 1;
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                int current = table[i][j];
                if(j + 1 <= col) table[i][j + 1] += current;
                if(i + 1 <= row) table[i + 1][j] += current;
            }
        }
        return table[row][col];
    }
    static boolean canSum(int targetSum, int[] numbers) {
        boolean[] table = new boolean[targetSum + 1];
        Arrays.fill(table, false);
        table[0] = true;
        for(int i = 0; i <= targetSum; i++) {
            if( table[i] == true )
                for(int num: numbers)
                    if(i + num <= targetSum) table[i + num] = true;
        }
        return table[targetSum];
    }
    static List<Integer> howSum(int targetSum, int[] numbers) {
        List<Integer>[] table = new List[targetSum + 1];
        Arrays.fill(table, null);
        table[0] = new ArrayList<>();
        for(int i = 0; i <= targetSum; i++) {
            if( table[i] != null ) {
                for(int num : numbers) {
                    if( i + num <= targetSum ) {
                        table[i + num] = new ArrayList<>(table[i]);
                        table[i + num].add(num);
                    }
                }
            }
        }
        return table[targetSum];
    }
    static List<Integer> bestSum(int targetSum, int[] numbers) {
        List<Integer>[] table = new List[targetSum + 1];
        for (int i = 0; i <= targetSum; i++) table[i] = new ArrayList<>();
        for (int i = 0; i <= targetSum; i++) {
            if (table[i] != null) {
                for (int num : numbers) {
                    if (i + num <= targetSum) {
                        List<Integer> temp = new ArrayList<>(table[i]);
                        temp.add(num);
                        if (table[i + num].isEmpty() || table[i + num].size() > temp.size()) table[i + num] = temp;
                    }
                }
            }
        }
        return table[targetSum];
    }
    static boolean canConstruct(String target, String[] wordBank) {
        boolean[] table = new boolean[target.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;
        for(int i = 0; i < target.length(); i++) {
            if(table[i] == true) {
                for(String word: wordBank) {
                    if(target.substring(i, i + word.length()) == word) {
                        table[i + word.length()] = true;
                    }
                }
            }
        }
        return table[target.length()];
    }
    static int countConstruct(String target, String[] wordBank) {
        int[] table = new int[target.length() + 1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for(int i = 0; i < target.length(); i++) {
            for(String word: wordBank) {
                if(i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)) {
                    table[i + word.length()] += table[i];
                }
            }
        }
        return table[target.length()];
    }
    static List<List<String>> allConstruct(String target, String[] wordBank) {
        List<List<String>>[] table = new List[target.length() + 1];
        Arrays.fill(table, new ArrayList<>());
        for (int i = 0; i <= target.length(); i++) {
            for (String word : wordBank) {
                if (i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)) {
                    List<List<String>> newCombinations = new ArrayList<>();
                    for (List<String> subArray : table[i]) {
                        List<String> combination = new ArrayList<>(subArray);
                        combination.add(word);
                        newCombinations.add(combination);
                    }
                    table[i + word.length()].addAll(newCombinations);
                }
            }
        }
        return table[target.length()];
    }
}