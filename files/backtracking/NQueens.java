package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(nQueens(4));
    }
    public static List<List<String>> nQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if(n <= 0) return ans;
        char[][] matrix = new char[n][n];
        for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) matrix[i][j] = '.';
        dfs(ans, matrix, 0);
        return ans;
    }

    public static void dfs(List<List<String>> ans, char[][] matrix, int rowIndex) {
        if(rowIndex == matrix.length) {
            ans.add(construct(matrix));
            return;
        }
        for(int i = 0; i < matrix.length; i++) {
            matrix[rowIndex][i] = 'Q';
            if(isValid(matrix, rowIndex, i)) dfs(ans, matrix, rowIndex + 1);
            matrix[rowIndex][i] = '.';
        }
        return;
    }
    private static boolean isValid(char[][]matrix, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // not need to check current position
                if (i == x && j == y) continue;
                // if 'Q' in the same col or the diagonal line, return false
                if ((j == y || Math.abs(x - i) == Math.abs(y - j)) && matrix[i][j] == 'Q') return false;
            }
        }
        return true;
    }
    private static List<String> construct(char[][] matrix) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            String sb = new String(matrix[i]);
            res.add(sb);
        }
        return res;
    }
}
