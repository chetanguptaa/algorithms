package practice;

import java.util.PriorityQueue;

public class OptimalMergePattern {
    public static void main(String[] args) {
        System.out.println(optimalMerge(new int[] { 4, 2, 5, 3, 1 }));
    }

    public static int optimalMerge(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.add(num);
        }
        int count = 0;
        while (pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            count += temp;
            pq.add(temp);
        }
        return count;
    }
}