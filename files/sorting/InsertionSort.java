package sorting;

public class InsertionSort {

    public void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 1, 2, 9, 10 };
        InsertionSort is = new InsertionSort();
        is.printArray(arr);
        is.sort(arr);
        is.printArray(arr);
    }
}