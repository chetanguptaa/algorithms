package recursion;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(waysInMatrix(4, 3));
    }
    static int waysInMatrix(int n, int m) {
        if(m == 1 || n == 1) return 1;
        return waysInMatrix(n - 1, m ) + waysInMatrix(n, m - 1 );
    }
}
