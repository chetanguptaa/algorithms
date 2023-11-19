package dp.knapsack;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        System.out.println(knapsack(new int[] { 1, 2, 3 }, new int[] { 1, 3, 5 }, 4, 3));
    }

    public static int knapsack(int[] wt, int[] val, int cap, int n) {
        int[][] matrix = new int[1000][1000];
        for (int[] ints : matrix) {
            Arrays.fill(ints, -1);
        }
        return helper(wt, val, cap, n, matrix);
    }

    private static int helper(int[] wt, int[] val, int cap, int n, int[][] matrix) {
        if (n == 0 || cap == 0)
            return 0;
        if (matrix[n][cap] != -1)
            return matrix[n][cap];
        if (wt[n - 1] <= cap) {
            matrix[n][cap] = Math.max(val[n - 1] + helper(wt, val, cap - wt[n - 1], n - 1, matrix),
                    helper(wt, val, cap, n - 1, matrix));
            return matrix[n][cap];
        }
        matrix[n][cap] = helper(wt, val, cap, n - 1, matrix);
        return matrix[n][cap];
    }
}