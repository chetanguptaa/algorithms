package dp.kadane;

public class MaxSum {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[] {2, 3, -9, 4}));
    }
    public static int maxSum(int[] arr) {
        int ans = arr[0];
        int curr = ans;
        for(int i = 1; i < arr.length; i++) {
            curr = Math.max(curr + arr[i], arr[i]);
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
