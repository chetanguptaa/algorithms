public class Reverse {

    public static void rev(int[] numbers, int start, int end) {
        while(start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] numbers = {2,3,4,5,6,7};
        printArray(numbers);
        rev(numbers, 0, numbers.length - 1);
        printArray(numbers);
    }
}