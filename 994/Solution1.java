class Solution {
    public int orangesRotting(int[][] grid) {
        int numMinutes = -1;
        int freshOranges = 0;

        Queue<int[]> queue = new LinkedList<>();
        //Add all rotten oranges in the queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int[][] possibleDirections = new int[][] {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int[] coord = queue.poll();
                int x = coord[0], y = coord[1];

                //check valid neighbors
                for (int[] direction : possibleDirections) {
                    int neighborX = x + direction[0];
                    int neighborY = y + direction[1];

                    if (isValidCoordinate(grid, neighborX, neighborY)) {
                        queue.offer(new int[] {neighborX, neighborY});
                        //Rot the cell
                        grid[neighborX][neighborY] = 2;
                        freshOranges--;
                    }
                }
            }
            numMinutes++;
        }

        return freshOranges == 0 ? Math.max(0, numMinutes) : - 1;
    }

    private boolean isValidCoordinate(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return false;
        }

        return true;
    }
}