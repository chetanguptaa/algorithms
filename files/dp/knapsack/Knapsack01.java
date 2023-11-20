package dp.knapsack;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        // System.out.println(knapsack(new int[] { 1, 2, 3 }, new int[] { 1, 3, 5 }, 4,
        // 3));
        System.out.println(knapsackBottomUp(new int[] { 1, 2, 3 }, new int[] { 1, 3, 5 }, 4, 3));
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

    public static int knapsackBottomUp(int[] wt, int[] val, int cap, int n) {
        int[][] matrix = new int[n + 1][cap + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < cap + 1; j++) {
                if (i == 0 || j == 0)
                    matrix[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < cap + 1; j++) {
                if (wt[i - 1] <= j) {
                    matrix[i][j] = Math.max(val[i - 1] + matrix[i - 1][j - wt[i - 1]], matrix[i - 1][j]);
                } else
                    matrix[i][j] = matrix[i - 1][j];
            }
        }
        return matrix[n][cap];
    }
}