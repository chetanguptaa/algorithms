package search;

public class LinearSearch {

    public int search(int[] arr, int n, int x) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 7, 5, 6, 3, 4, 8, 2, 3, 12, 65, 34, 78 };
        LinearSearch ls = new LinearSearch();
        System.out.println(ls.search(arr, arr.length, 78));
    }
}