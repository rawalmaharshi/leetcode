class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //edge case
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int dfsMax = dfs(grid, i, j, 0);
                    max = Math.max(max, dfsMax);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j, int currentMax) {
        //base case
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return currentMax;
        }

        //mark visited
        grid[i][j] = 0;

        //dfs
        return 1 + dfs(grid, i + 1, j, currentMax) + dfs(grid, i - 1, j, currentMax) + dfs(grid, i, j + 1, currentMax) + dfs(grid, i, j - 1, currentMax);
    }
}