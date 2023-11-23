package dp.knapsack;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[] { 2, 3, 7, 8, 10 }, 11, 5));
        System.out.println(subsetSumRec(new int[] { 2, 3, 7, 8, 10 }, 11, 5));
    }
    public static boolean subsetSum(int[] arr, int sum, int n) {
        boolean[][] matrix = new boolean[n + 1][sum + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = j == 0;
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
    public static boolean subsetSumRec(int[] arr, int sum, int n) {
        return helper(arr, sum, n - 1);
    }
    private static boolean helper(int[] arr, int sum, int n) {
        if(sum == 0) return true;
        if(n == 0) return false;
        if (arr[n - 1] <= sum) {
            return helper(arr, sum - arr[n], n - 1) || helper(arr, sum, n - 1);
        }
        return helper(arr, sum, n - 1);
    }
}
