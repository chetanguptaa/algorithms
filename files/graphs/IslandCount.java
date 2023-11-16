package graphs;

public class IslandCount {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}}));
    }
    public static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    explore(grid, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private static void explore(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '0';
        explore(grid, m, n, i + 1, j);
        explore(grid, m, n, i - 1, j);
        explore(grid, m, n, i, j + 1);
        explore(grid, m, n, i, j - 1);
    }
}
