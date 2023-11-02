import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Leetcode {
    public static void main(String args[]) {
        int count = 0;
        int r = 3;
        int p = -10;
        int q = 30;
        for(int i = p; i <= q; i++) {
            if (Math.abs(i) % r == 0) count++;
        }
        System.out.println(count);
    }
}