class Solution {
    public void wallsAndGates(int[][] rooms) {
        //edge case
        if (rooms == null || rooms.length == 0) {
            return ;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        int distance = 1;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int[] coord = queue.poll();
                int x = coord[0], y = coord[1];

                for (int[] direction : directions) {
                    int neighborX = x + direction[0];
                    int neighborY = y + direction[1];

                    if (isValidCoordinate(rooms, neighborX, neighborY)) {
                        //mark coordinate
                        rooms[neighborX][neighborY] = distance;
                        queue.offer(new int[]{neighborX, neighborY});
                    }
                }
            }
            distance++;
        }

        return ;
    }

    private boolean isValidCoordinate(int[][] rooms, int x, int y) {
        if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] == 0 || rooms[x][y] == -1 || rooms[x][y] != Integer.MAX_VALUE) {
            return false;
        }

        return true;
    }
}