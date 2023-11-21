package dp.knapsack;

public class EqualSumPartition {
    public static void main(String[] args) {
        System.out.println(equalSumPartition(new int[] { 2, 3, 5, 2 }, 3));
    }

    public static boolean equalSumPartition(int[] nums, int n) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        return subsetSum(nums, sum / 2, n);
    }

    private static boolean subsetSum(int[] nums, int sum, int n) {
        boolean[][] matrix = new boolean[n + 1][sum + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = j == 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    matrix[i][j] = matrix[i - 1][j - nums[i - 1]] || matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        return matrix[n][sum];
    }
}
