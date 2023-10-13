package practice;

import java.util.ArrayList;

public class Practice {
    public static void main(String[] args) {
        // printAllTheFacts(20);
    }

    public static void printAllTheFacts(int n) {
        ArrayList<Integer> facts = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if ((n / i) == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    facts.add(n / i);
                }
            }
        }
        for (int i = facts.size() - 1; i >= 0; i--) {
            System.out.print(facts.get(i) + " ");
        }
    }

    public int minProductArr(int[] arr1, int[] arr2, int k) {
        int ans = 0;
        int n = arr1.length;
        int[] multArr = new int[n];
        for (int i = 0; i < n; i++) {
            int multiple = arr1[i] * arr2[i];
            multArr[i] = multiple;
            ans += multiple;
        }
        return ans;
    }
}
