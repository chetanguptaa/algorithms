package maths;

import java.util.*;

public class Maths {
    public static void main(String[] args) {
//        System.out.println(trailingZerosInFact(100));
//        System.out.println(palindromNum(121));
        System.out.println(fastPower(2, 3));
    }
    static int trailingZerosInFact(int n) {
        int res = 0;
        for(int i = 5; i < n; i *= 5) {
            res += n / i;
        }
        return res;
    }
    static boolean palindromNum(int n) {
        int newNum = 0;
        int ans = n;
        while(ans != 0) {
            newNum = newNum * 10 + ans % 10;
            ans /= 10;
        }
        return n == newNum;
    }
    static boolean[] primeInARange(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i = 2; i * i <= n; i++) {
            for(int j = 2 * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    static int fastPower(int a, int b) {
        int res = 1;
        while(b > 0) {
            if((b & 1) != 0) {
                res *= a;
            }
            a *= a;
            b = b >> 1;
        }
        return res;
    }
}
