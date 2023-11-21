package dp.unboundedKnapsack;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        System.out.println(unboundedKnapsack(new int[] { 1, 2, 3 }, new int[] { 1, 3, 5 }, 3, 4));
    }
    public static int unboundedKnapsack(int[] wt, int[] val, int n, int cap)  {
        int[][] matrix = new int[n + 1][cap + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < cap + 1; j++) {
                if (i == 0 || j == 0) matrix[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < cap + 1; j++) {
                if (wt[i - 1] <= j) matrix[i][j] = Math.max(val[i - 1] + matrix[i][j - wt[i - 1]], matrix[i - 1][j]);
                else matrix[i][j] = matrix[i - 1][j];
            }
        }
        return matrix[n][cap];
    }
}