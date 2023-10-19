public class Missing {

    public static void number(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] > 1) {
                System.out.println(arr[i] + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 6, 7, 8, 9 };
        number(nums);
    }
}