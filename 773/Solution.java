class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // dfsHelper(image, sr, sc, color, image[sr][sc]);
        // return image;
        return bfsHelper(image, sr, sc, color);
    }
    
    public int[][] bfsHelper(int[][] image, int sr, int sc, int color) {
        //edge case
        if (image[sr][sc] == color) {
            return image;   //no change required
        }
        
        int origColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        
        while(!queue.isEmpty()) {
            int[] coord = queue.poll();
            int row = coord[0], col = coord[1];
            if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || color == image[row][col] || image[row][col] != origColor) {
                continue;
            }
            
            //flood fill
            image[row][col] = color;
            
            //add neighbors to queue for bfs
            queue.offer(new int[] {row + 1, col});
            queue.offer(new int[] {row - 1, col});
            queue.offer(new int[] {row, col + 1});
            queue.offer(new int[] {row, col - 1});
        }
        
        return image;
    }
    
    public void dfsHelper(int[][] image, int row, int col, int color, int origColor) {
        //base case
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || color == origColor || image[row][col] != origColor) {
            return ;
        }
        
        //flood fill
        image[row][col] = color;
        
        //dfs
        dfsHelper(image, row + 1, col, color, origColor);
        dfsHelper(image, row - 1, col, color, origColor);
        dfsHelper(image, row, col + 1, color, origColor);
        dfsHelper(image, row, col - 1, color, origColor);
        
        return ;
    }
}