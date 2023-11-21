package dp.knapsack;

public class CountSubsetsWithAGivenDiff {
    public static void main(String[] args) {
        System.out.println(countSubsetsWithAGivenDiff(new int[] {1, 1, 1, 1, 1}, 3, 5));
    }
    public static int countSubsetsWithAGivenDiff(int[] nums, int diff, int n) {
        int sum = 0;
        for(int num: nums) sum += num;
        return subsetSum(nums, (sum - diff) / 2, n);
    }
    private static int subsetSum(int[] arr, int sum, int n) {
        int[][] matrix = new int[n + 1][sum + 1];
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(j == 0) matrix[i][j] = 1;
                else matrix[i][j] = 0;
            }
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(arr[i - 1] <= j) matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - arr[i - 1]];
                else matrix[i][j] = matrix[i - 1][j];
            }
        }
        return matrix[n][sum];
    }
}