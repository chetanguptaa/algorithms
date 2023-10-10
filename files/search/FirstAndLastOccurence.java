package search;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        System.out.println(noOfCount(new int[] {1, 2, 2, 2, 3}, 2));
    }
    public static int firstOccurence(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static int lastOccurence(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = Integer.MIN_VALUE;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
    private static int noOfCount(int[] nums, int target) {
        return lastOccurence(nums, target) - firstOccurence(nums, target) + 1;
    }
}
