package recursion;

public class Recursion {
    public static void main(String[] args) {
        // System.out.println(waysInMatrix(4, 3));
        // System.out.println(josephusProblem(5, 3));
        // System.out.println(palindromString("racecar", 0, 6));
        // noOfSubSequence("abc", 0, "");
        permutationOfAString("abc", 0, 2);
    }

    static int waysInMatrix(int n, int m) {
        if (m == 1 || n == 1)
            return 1;
        return waysInMatrix(n - 1, m) + waysInMatrix(n, m - 1);
    }

    static int josephusProblem(int n, int k) {
        if (n == 1)
            return 0;
        return (josephusProblem(n - 1, k) + k) % n;
    }

    static boolean palindromString(String s, int l, int r) {
        if (l >= r)
            return true;
        if (s.charAt(l) != s.charAt(r))
            return false;
        return palindromString(s, l + 1, r - 1);
    }

    static void noOfSubSequence(String s, int i, String curr) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }
        noOfSubSequence(s, i + 1, curr + s.charAt(i));
        noOfSubSequence(s, i + 1, curr);
    }

    static void permutationOfAString(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
            return;
        }
        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            permutationOfAString(s, l + 1, r);
            s = swap(s, l, i);
        }
    }

    private static String swap(String s, int l, int i) {
        StringBuilder sb = new StringBuilder(s);
        char temp = s.charAt(i);
        sb.replace(i, i + 1, String.valueOf(s.charAt(l)));
        sb.replace(l, l + 1, String.valueOf(temp));
        return sb.toString();
    }
}
