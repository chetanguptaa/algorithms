package dp.knapsack;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[] { 2, 3, 7, 8, 10 }, 11, 5));
    }

    public static boolean subsetSum(int[] arr, int sum, int n) {
        boolean[][] matrix = new boolean[n + 1][sum + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) matrix[i][j] = true;
                else matrix[i][j] = false;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    matrix[i][j] = matrix[i - 1][j - arr[i - 1]] || matrix[i - 1][j];
                } else matrix[i][j] = matrix[i - 1][j];
            }
        }
        return matrix[n][sum];
    }
}
