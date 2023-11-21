package dp.knapsack;

public class MinimumSubsetDiff {
    public static void main(String[] args) {
        System.out.println(minSubsetDiff(new int[] { 1, 2, 5 }, 3));
    }

    public static int minSubsetDiff(int[] nums, int n) {
        int sum = 0;
        for (int num : nums) sum += num;
        boolean[] range = subsetSum(nums, sum, n);
        int ans = Integer.MAX_VALUE;
        for (int i = sum / 2 - 1; i >= 0; i--) {
            if (range[i]) ans = Math.min(ans, sum - 2 * i);
        }
        return ans;
    }

    private static boolean[] subsetSum(int[] arr, int sum, int n) {
        boolean[][] matrix = new boolean[n + 1][sum + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = j == 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) matrix[i][j] = matrix[i - 1][j - arr[i - 1]] || matrix[i - 1][j];
                else matrix[i][j] = matrix[i - 1][j];
            }
        }
        return matrix[n];
    }
}
