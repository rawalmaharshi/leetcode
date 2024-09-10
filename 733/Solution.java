class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // return dfs(image, sr, sc, image[sr][sc], color);
        return bfs(image, sr, sc, image[sr][sc], color);
    }

    private int[][] dfs(int[][] image, int r, int c, int origColor, int color) {
        //base case
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != origColor || image[r][c] == color) {
            return image;
        }

        //flood fill
        image[r][c] = color;

        //dfs
        dfs(image, r + 1, c, origColor, color);
        dfs(image, r - 1, c, origColor, color);
        dfs(image, r, c + 1, origColor, color);
        dfs(image, r, c - 1, origColor, color);

        return image;
    }

    private int[][] bfs(int[][] image, int r, int c, int origColor, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int[] coord = queue.poll();
                int x = coord[0], y = coord[1];
                //flood fill
                image[x][y] = color;
                
                //bfs
                int[][] directions = {
                    {1, 0}, {-1, 0}, {0, 1}, {0, -1}
                };

                for (int[] direction : directions) {
                    int neighborX = x + direction[0];
                    int neighborY = y + direction[1];
                    if (isValidCoordinate(image, neighborX, neighborY, origColor, color)) {
                        queue.offer(new int[] {neighborX, neighborY});
                    }
                }
            }
        }

        return image;
    }

    private boolean isValidCoordinate(int[][] image, int r, int c, int origColor, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != origColor || image[r][c] == color) {
            return false;
        }

        return true;
    }
}