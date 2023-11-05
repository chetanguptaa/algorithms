package backtracking;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println(exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }
    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(backtrack(board, i, j, word, 0)) return true;
            }
        return false;
    }
    private static boolean backtrack(char[][] board, int i, int j, String word, int idx) {
        if(idx == word.length()) return true;
        if(i > board.length - 1 || i < 0 || j < 0 || j > board[0].length-1 || board[i][j] != word.charAt(idx)) return false;
        board[i][j]='*';
        boolean result =
                backtrack(board, i - 1, j, word, idx + 1) ||
                backtrack(board, i, j - 1, word, idx + 1) ||
                backtrack(board, i, j + 1, word, idx + 1) ||
                backtrack(board, i + 1, j, word, idx + 1);
        board[i][j] = word.charAt(idx);
        return result;
    }
}
