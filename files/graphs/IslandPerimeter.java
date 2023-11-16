package graphs;

public class IslandPerimeter {
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0, neighbors = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    islands++;
                    if(i < m - 1 && grid[i + 1][j] == 1) neighbors++;
                    if(j < n - 1 && grid[i][j + 1] == 1) neighbors++;
                }
            }
        }
        return 4 * islands - neighbors * 2;
    }
}
