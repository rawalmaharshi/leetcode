class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numProvinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {//start dfs
                    numProvinces++;
                    dfs(isConnected, i);    //start dfs on ith row
                }
            }
        }
        return numProvinces;
        // return bfs(isConnected);
    }
    
    public int bfs(int[][] matrix) {
        int numProvinces = 0;
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int row = queue.poll();
                    visited[row] = 1;
                    for (int j = 0; j < matrix[row].length; j++) {
                        if (matrix[row][j] == 1 && visited[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
            numProvinces++;
            }           
        }
        
        return numProvinces;
    }
    
    public void dfs(int[][] matrix, int i) {
        //base case
        if (matrix[i][i] == 0) {
            return;
        }
        
        //Start dfs on the i-th row, this way all the adjacent elements will be marked 0
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 1) {
                matrix[i][j] = 0;   //mark visited
                dfs(matrix, j);
            }
        }
        return;
    }
}