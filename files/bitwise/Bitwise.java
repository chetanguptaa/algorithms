package bitwise;

import java.util.Arrays;

public class Bitwise {
    public static void main(String[] args) {
        // System.out.println(oddNumber(22));
        // System.out.println(Arrays.toString(swapTwoNumbers(23, 21)));
        // System.out.println(findIthBit(12, 4));
        // System.out.println(setIthBit(21, 2));
        // System.out.println(clearIthBit(23, 2));
        // System.out.println(noOfBitsToConvertAToB(13, 12));
        // System.out.println(nonRepeating(new int[] {5,4,1,4,3,1,5}));
        System.out.println(Arrays.toString(twoNonRepeating(new int[] { 5, 4, 1, 4, 3, 1, 5, 2 })));
    }

    static boolean oddNumber(int n) {
        return (n & 1) != 0;
    }

    static int[] swapTwoNumbers(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[] { a, b };
    }

    static int findIthBit(int n, int i) {
        if (((1 << i) & n) == 0)
            return 0;
        return 1;
    }

    static int setIthBit(int n, int i) {
        n = (1 << i) | n;
        return n;
    }

    static int clearIthBit(int n, int i) {
        n = ~(1 << i) & n;
        return n;
    }

    static int noOfBitsToConvertAToB(int a, int b) {
        int n = a ^ b;
        int counter = 0;
        while (n != 0) {
            n = n & (n - 1);
            counter++;
        }
        return counter;
    }

    static int nonRepeating(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            res = res ^ arr[i];
        if (res == 0)
            return -1;
        return res;
    }

    static int[] twoNonRepeating(int[] arr) {
        int res1 = 0;
        for (int i = 0; i < arr.length; i++)
            res1 = res1 ^ arr[i];
        res1 = (res1 & -res1);
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & res1) > 0) {
                sum1 = (sum1 ^ arr[i]);
            } else {
                sum2 = (sum2 ^ arr[i]);
            }
        }
        return new int[] { sum1, sum2 };
    }
}
