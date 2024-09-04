class Solution {
    public int numDistinctIslands(int[][] grid) {
        //edge case
        if (grid == null || grid.length == 0) {
            return 0;
        }

        Set<Set<Pair<Integer, Integer>>> islands = new HashSet<>();        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Set<Pair<Integer, Integer>> currentIsland = dfs(grid, i, j, i, j, new HashSet<>());
                    islands.add(currentIsland);
                }
            }
        }

        return islands.size();
    }

    private Set<Pair<Integer, Integer>> dfs(int[][] grid, int origRow, int origCol, int i, int j, Set<Pair<Integer, Integer>> currentIsland) {
        //base case
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return currentIsland;
        }

        //mark visited
        grid[i][j] = 0;

        //add to set (remember to subtract the origin row and column)
        currentIsland.add(new Pair<>(i - origRow, j - origCol));

        //dfs
        dfs(grid, origRow, origCol, i + 1, j, currentIsland);
        dfs(grid, origRow, origCol, i - 1, j, currentIsland);
        dfs(grid, origRow, origCol, i, j + 1, currentIsland);
        dfs(grid, origRow, origCol, i, j - 1, currentIsland);

        return currentIsland;
    }
}

/**
    Trick - 
    We can also make one other clever observation: we can simply translate each island so that the first cell of the island that is discovered is on (0, 0). If, for example, an island contains the cells [(2, 3), (2, 4), (2, 5), (3, 5)], we subtract (2, 3) off each cell to get [(0, 0), (0, 1), (0, 2), (1, 2)].

    This way no matter what the coordinates are for similar islands, they are always starting from (0,0)
 */