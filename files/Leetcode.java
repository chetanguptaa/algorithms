import java.util.*;

public class Leetcode {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    public static int factorial(int n) {
        return factorialDP(n, new HashMap<Integer, Integer>());
    }

    private static int factorialDP(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n))
            return map.get(n);
        if (n <= 2)
            return 1;
        map.put(n, factorialDP(n - 1, map) + factorialDP(n - 2, map));
        return map.get(n);
    }
}