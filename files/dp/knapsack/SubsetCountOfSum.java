package dp.knapsack;

public class SubsetCountOfSum {
    public static void main(String[] args) {
        System.out.println(subsetCountOfSum(new int[] { 1, 2, 3, 3 }, 6, 4));
    }

    public static int subsetCountOfSum(int[] nums, int target, int n) {
        int[][] matrix = new int[n + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j == 0)
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (nums[i - 1] <= j) {
                    matrix[i][j] = matrix[i - 1][j - nums[i - 1]] + matrix[i - 1][j];
                } else
                    matrix[i][j] = matrix[i - 1][j];
            }
        }
        return matrix[n][target];
    }
}
