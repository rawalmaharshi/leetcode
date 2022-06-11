class Solution {
    public int orangesRotting(int[][] grid) {
        //edge case
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int[][] possibleDirections = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        
        int numMinutes = 0;
        
        //Seen grid - Initialized with false
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        //For starting the rotting procedure - add all the rotten oranges' location into the queue. That would signify that at the 1st minute (i.e first iteration of bfs queue) all these oranges start rotting their neighbors
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        //Start bfs
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            boolean rottedNeighbor = false;
            for (int k = 0; k < queueSize; k++) {
                int[] coord = queue.poll();
                int i = coord[0], j = coord[1];
                //Rot the current orange (happens from 2nd iteration; since in first iteration all oranges in queue are already rotten)
                grid[i][j] = 2;
                
                //rot neighbors
                for (int[] direction : possibleDirections) {
                    int neighborX = direction[0] + i;
                    int neighborY = direction[1] + j;
                    
                    if (isValidCoordinate(grid, neighborX, neighborY) && grid[neighborX][neighborY] == 1 && !seen[neighborX][neighborY]) {
                        queue.offer(new int[] {neighborX, neighborY});
                        seen[neighborX][neighborY] = true;
                        rottedNeighbor = true;
                    }
                }
            }
            
            if (rottedNeighbor) {
                numMinutes++;
            }
        }
        
        //Check if any fresh orange
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return numMinutes;
    }
    
    public boolean isValidCoordinate(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        }
        
        return true;
    }
}