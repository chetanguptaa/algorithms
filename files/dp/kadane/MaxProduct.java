package dp.kadane;

public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct1(new int[] { 2, 3, -2, 4 }));
        System.out.println(maxProduct2(new int[] { 2, 3, -2, 4 }));
    }
    public static int maxProduct1(int[] nums) {
        int n = nums.length;
        int[] maxVal = new int[n];
        int[] minVal = new int[n];
        maxVal[0] = nums[0];
        minVal[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxVal[i] = Math.max(maxVal[i - 1] * nums[i], Math.max(minVal[i - 1] * nums[i], nums[i]));
            minVal[i] = Math.min(maxVal[i - 1] * nums[i], Math.min(minVal[i - 1] * nums[i], nums[i]));
        }
        int ans = Integer.MIN_VALUE;
        for (int num : maxVal) ans = Math.max(ans, num);
        return ans;
    }

    // Further Optimization
    public static int maxProduct2(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int currMin = nums[0];
        int ans = currMax;
        for (int i = 1; i < n; i++) {
            int temp = currMax;
            currMax = Math.max(temp * nums[i], Math.max(currMin * nums[i], nums[i]));
            currMin = Math.min(temp * nums[i], Math.min(currMin * nums[i], nums[i]));
            ans = Math.max(ans, currMax);
        }
        return ans;
    }
}
