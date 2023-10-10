package search;

public class BinarySearch {
    public int search(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = (high + low)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = { 1, 10, 20, 47, 59, 65, 75, 88, 99 };
        System.out.println(bs.search(nums, 65));
    }
}