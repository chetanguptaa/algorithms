package dp;

public class DynamicProgrammingTab {
    public static void main(String[] args) {
//        System.out.println(fib(5));
        System.out.println(gridTraveller(3, 3));
    }
    static int fib(int n) {
        int[] table = new int[n + 1];
        for(int num: table) num = 0;
        table[1] = 1;
        for (int i = 0; i < n; i++) {
            if(i == n - 1) table[i + 1] += table[i];
            else {
                table[i + 1] += table[i];
                table[i + 2] += table[i];
            }
        }
        return table[n];
    }
    static int gridTraveller(int row, int col) {
        int[][] table = new int[row + 1][col + 1];
        table[1][1] = 1;
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                int current = table[i][j];
                if(j + 1 <= col) table[i][j + 1] += current;
                if(i + 1 <= row) table[i + 1][j] += current;
            }
        }
        return table[row][col];
    }
}
