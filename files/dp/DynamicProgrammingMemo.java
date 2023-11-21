package dp;

import java.util.*;

public class DynamicProgrammingMemo {
    public static void main(String[] args) {
        // System.out.println(fibDp(5, new HashMap<>()));
        // System.out.println(gridTravellerDp(18, 18, new HashMap<>()));
        // System.out.println(canSum(7, new int[] { 5, 3, 4, 7 }));
        // System.out.println(canSumDp(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        // System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
        // System.out.println(howSumDp(300, new int[]{7, 14}, new HashMap<>()));
        // System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
        // System.out.println(bestSumDp(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        // System.out.println(canConstruct("skateboard", new String[] {"bo", "rd",
        // "ate", "t", "ska", "sk", "boar"}));
        // System.out.println(canConstructDp("skateboard", new String[] {"bo", "rd",
        // "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        // System.out.println(countConstruct("abc", new String[] {"a", "b", "c",
        // "abc"}));
        // System.out.println(allConstruct("abcdef", new String[] {"ab", "abc", "cd",
        // "def", "abcd", "ef", "c"}));
        // System.out.println(allConstructDp("abcdef", new String[] {"ab", "abc", "cd",
        // "def", "abcd", "ef", "c"}, new HashMap<>()));
    }

    static int fibDp(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) return 1;
        memo.put(n, fibDp(n - 1, memo) + fibDp(n - 2, memo));
        return memo.get(n);
    }

    static int gridTravellerDp(int numOfRow, int numOfCol, Map<List<Integer>, Integer> memo) {
        List<Integer> list = new ArrayList<>(Arrays.asList(numOfRow, numOfCol));
        List<Integer> listReverse = new ArrayList<>(Arrays.asList(numOfCol, numOfRow));
        if (memo.containsKey(list))
            return memo.get(list);
        if (memo.containsKey(listReverse))
            return memo.get(listReverse);
        if (numOfRow == 0 || numOfCol == 0)
            return 0;
        if (numOfRow == 1 && numOfCol == 1)
            return 1;
        memo.put(list, gridTravellerDp(numOfRow - 1, numOfCol, memo) + gridTravellerDp(numOfRow, numOfCol - 1, memo));
        return memo.get(list);
    }

    static boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int num : numbers) {
            if (canSum(targetSum - num, numbers))
                return true;
        }
        return false;
    }

    static boolean canSumDp(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int num : numbers) {
            int rem = targetSum - num;
            if (canSumDp(rem, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    static List<Integer> howSum(int targetSum, int[] numbers) {
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSum(remainder, numbers);
            if (remainderResult != null) {
                remainderResult.add(num);
                return remainderResult;
            }
        }
        return null;
    }

    static List<Integer> howSumDp(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSumDp(remainder, numbers, memo);
            if (remainderResult != null) {
                remainderResult.add(num);
                memo.put(remainder, remainderResult);
                return remainderResult;
            }
        }
        memo.put(targetSum, null);
        return memo.get(targetSum);
    }

    static List<Integer> bestSum(int targetSum, int[] numbers) {
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        List<Integer> ans = null;
        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = bestSum(remainder, numbers);
            if (remainderResult != null) {
                remainderResult.add(num);
                if (ans == null || remainderResult.size() < ans.size()) {
                    ans = remainderResult;
                }
            }
        }
        return ans;
    }

    static List<Integer> bestSumDp(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        List<Integer> ans = null;
        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = bestSumDp(remainder, numbers, memo);
            if (remainderResult != null) {
                remainderResult.add(num);
                if (ans == null || remainderResult.size() < ans.size())
                    ans = remainderResult;
            }
        }
        memo.put(targetSum, ans);
        return ans;
    }

    static boolean canConstruct(String target, String[] wordBank) {
        if (target == "")
            return true;
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (canConstruct(suffix, wordBank))
                    return true;
            }
        }
        return false;
    }

    static boolean canConstructDp(String target, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target == "")
            return true;
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (canConstructDp(suffix, wordBank, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    static int countConstruct(String target, String[] wordBank) {
        int count = 0;
        if (target == "")
            return 1;
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                int noWaysForRest = countConstruct(suffix, wordBank);
                count += noWaysForRest;
            }
        }
        return count;
    }

    static int countConstructDp(String target, String[] wordBank, Map<String, Integer> memo) {
        if (memo.containsKey(target))
            return memo.get(target);
        int count = 0;
        if (target == "")
            return 1;
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                int noWaysForRest = countConstructDp(suffix, wordBank, memo);
                count += noWaysForRest;
            }
        }
        memo.put(target, count);
        return count;
    }

    static List<List<String>> allConstruct(String target, String[] wordBank) {
        if (target.equals("")) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        List<List<String>> allWays = new ArrayList<>();
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank);
                for (List<String> way : suffixWays)
                    way.add(0, word);
                allWays.addAll(suffixWays);
            }
        }
        return allWays;
    }

    static List<List<String>> allConstructDp(String target, String[] wordBank, Map<String, List<List<String>>> memo) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target.equals("")) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        List<List<String>> allWays = new ArrayList<>();
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstructDp(suffix, wordBank, memo);
                for (List<String> way : suffixWays) {
                    List<String> wayListsWithWord = new ArrayList<>(way);
                    wayListsWithWord.add(0, word);
                    allWays.add(wayListsWithWord);
                }
            }
        }
        memo.put(target, allWays);
        return allWays;
    }
}
