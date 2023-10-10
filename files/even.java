public class Even {
    public static int[] removeEven(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 6, 7, 8, 9, 10 };

        int[] result = removeEven(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}