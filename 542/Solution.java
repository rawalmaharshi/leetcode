class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // return usingBFS(mat);
        return usingDP(mat);
    }
    
    public int[][] usingBFS(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = mat.length, cols = mat[0].length;
        int[][] distance = new int[rows][cols];
        //initialize distance array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //add all occurences of 0 to queue
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()) {
            int[] coord = queue.poll();
            int x = coord[0], y = coord[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];
                
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols) {
                    if (distance[newX][newY] > distance[x][y] + 1) {
                        distance[newX][newY] = distance[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }    
                }
                
            }
        }
        
        return distance;
    }
    
    public int[][] usingDP(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] distance = new int[rows][cols];
        //initialize distance array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    distance[i][j] = Integer.MAX_VALUE - 10000;     //to prevent roll-over
                }
            }
        }
        
        //1st pass - top and left
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                } else {
                    if (i > 0) {
                        distance[i][j] = Math.min(distance[i][j], distance[i - 1][j] + 1);
                    }

                    if (j > 0) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][j - 1] + 1);
                    }
                }
            }
        }
        
        //2nd pass - bottom and right
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1) {
                    distance[i][j] = Math.min(distance[i][j], distance[i + 1][j] + 1);
                }
                
                if (j < cols - 1) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][j + 1] + 1);
                }
            }
        }
        
        return distance;
    }
}