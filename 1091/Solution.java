class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //edge case
        if (grid == null || grid.length == 0 
        || grid[0][0] == 1 
        || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }

        //edge case
        if (grid.length == 1 && grid[0][0] == 0) {
            return 1;
        }

        int[][] possibleDirections = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1},
            {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };

        int pathLength = 1;
        boolean[][] seen = new boolean[grid.length][grid.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int[] coord = queue.poll();
                int i = coord[0], j = coord[1];
                

                for (int[] direction : possibleDirections) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    
                    //check if bottom right neighbor
                    if (x == grid.length - 1 && y == grid.length - 1) {
                        return pathLength + 1;
                    }

                    //add neighbors
                    if (isValidCoordinate(grid, x, y) && seen[x][y] == false) {
                        //offer it to the queue
                        queue.offer(new int[]{x, y});
                        //visit the node
                        seen[x][y] = true;
                    }
                }
            }
            //increase pathLength since all nodes at this distance have been processed
            pathLength++;
        }

        return -1;
    }

    private boolean isValidCoordinate(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1) {
            return false;
        }

        return true;
    }
}