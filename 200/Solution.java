class Solution {
    public int numIslands(char[][] grid) {
        //edge case
        if (grid.length == 0) {
            return 0;
        }
        
        // int numberOfIslands = dfs(grid);
        int numberOfIslands = bfs(grid);
        return numberOfIslands;
    }
    
    public int bfs(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    bfsHelper(grid, i, j);
                }
            }
        }
        return numIslands;
    }
    
    public void bfsHelper(char[][] grid, int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                Pair cord = queue.poll();
                int x = cord.x, y = cord.y;
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == '0')
                    continue;
                //mark visited
                grid[x][y] = '0';
                queue.offer(new Pair(x + 1, y));
                queue.offer(new Pair(x, y + 1));
                queue.offer(new Pair(x - 1, y));
                queue.offer(new Pair(x, y - 1));
            }
        }
        
        return ;
    }
    
    public int dfs(char[][] grid) {
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands += 1;
                    dfsHelper(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }
    
    public void dfsHelper(char[][] grid, int i , int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') 
            return ;
        
        grid[i][j] = '0';
        dfsHelper(grid, i, j - 1);
        dfsHelper(grid, i, j + 1);
        dfsHelper(grid, i + 1, j);
        dfsHelper(grid, i - 1, j);
        
        return ;
    }
}

class Pair {
    int x;
    int y;
    
    public Pair (int x, int y) {
        this.x = x;
        this.y = y;   
    }
}