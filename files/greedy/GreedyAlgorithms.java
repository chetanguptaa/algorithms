package greedy;

import java.util.*;

public class GreedyAlgorithms {
    public static void main(String[] args) {
        // System.out.println(bulbCost(new boolean[] {false, false, false}));
        // System.out.println(highestProductOfThree(new int[] {-5,-2,-1,0,0,1,1,5}));
        // System.out.println(disjointIntervals(new int[][] {{1,4}, {2, 3}, {3, 5},
        // {6,7}}));
        // System.out.println(Arrays.toString(largestPermutation(new int[] {3,2,4,1,5},
        // 3)));
        // System.out.println(meetingRooms(new int[][] {{5, 10}, {15, 20}, {0,30}}));
        System.out.println(distributeCandy(new int[] { 1, 3, 7, 1 }));
    }

    static int bulbCost(boolean[] bulbs) {
        int cost = 0;
        for (boolean bulb : bulbs) {
            if (cost % 2 != 0) bulb = !bulb;
            if (bulb) continue;
            else
                cost += 1;
        }
        return cost;
    }

    static int highestProductOfThree(int[] a) {
        Arrays.sort(a);
        int l = a.length;
        return Math.max(a[0] * a[1] * a[l - 1], a[l - 1] * a[l - 2] * a[l - 3]);
    }

    static int disjointIntervals(int[][] a) {
        int count = 1;
        Arrays.sort(a, Comparator.comparingInt(o -> o[1]));
        int prev_s = a[0][0];
        int prev_e = a[0][1];
        for (int[] arr : a) {
            if (arr[0] <= prev_e)
                continue;
            else {
                prev_s = arr[0];
                prev_e = arr[1];
                count += 1;
            }
        }
        return count;
    }

    static int[] largestPermutation(int[] arr, int b) {
        while (b != 0) {
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[idx] < arr[i]) {
                    int temp = arr[idx];
                    arr[idx] = arr[i];
                    arr[i] = temp;
                    idx++;
                }
            }
            b--;
        }
        return arr;
    }

    static int meetingRooms(int[][] meetingIntervals) {
        int count = 1;
        Arrays.sort(meetingIntervals, Comparator.comparingInt(o -> o[1]));
        for (int i = 1; i < meetingIntervals.length; i++) {
            if (meetingIntervals[i][0] < meetingIntervals[i - 1][1])
                count++;
        }
        return count;
    }

    static int distributeCandy(int[] ratings) {
        int n = ratings.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = ratings[i];
            data[i][1] = i;
        }
        Arrays.sort(data, (a, b) -> Integer.compare(a[0], b[0]));
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int[] pair : data) {
            int i = pair[1];
            if (i > 0 && ratings[i] > ratings[i - 1])
                candies[i] = Math.max(candies[i], candies[i - 1] + 1);
            if (i < n - 1 && ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        int totalCandies = 0;
        for (int count : candies)
            totalCandies += count;
        return totalCandies;
    }
}