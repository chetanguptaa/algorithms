public class Secondmax {
    public static void max(int[] arr) {
        int max = arr[0];
        int secondmax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                int temp = max;
                max = arr[i];
                secondmax = temp;
            }
        }
        System.out.println(secondmax);
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 3, 4, 0, 9, 14, 16, 67 };
        max(numbers);
    }
}