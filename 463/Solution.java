class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //Find the starting point for dfs
                if (grid[i][j] == 1) {
                    perimeter = dfs(grid, i, j);
                }
            }
        }
        return perimeter;
    }
    
    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 1;
        }
        
        if (grid[i][j] == 0) {
            return 1;
        }
        
        //these grids are already visited and marked as -1
        if (grid[i][j] == -1) {
            return 0;
        }
        
        grid[i][j] = -1;
        int count = 0;
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j - 1);
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i, j + 1);
        return count;
    }
    
    public int bruteForce(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)    continue;   //skip, this is water
                if (grid[i][j] == 1) {
                    //check all four sides
                    if ((i - 1) < 0 || grid[i - 1][j] == 0) perimeter += 1;
                    if ((j - 1) < 0 || grid[i][j - 1] == 0) perimeter += 1;
                    if ((i + 1) >= grid.length || grid[i + 1][j] == 0)  perimeter += 1;
                    if ((j + 1) >= grid[0].length || grid[i][j + 1] == 0)   perimeter += 1;
                }
            }
        }
        
        return perimeter;
    }
}