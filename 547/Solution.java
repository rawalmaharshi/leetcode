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

/**
------------------ SOLUTION USING UNION FIND ------------------
 */

class Solution2 {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        
        UnionFind uf = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.getProvinceCount();
    }
}

class UnionFind {
    private int[] root;
    private int[] rank;
    private int count;
    
    public UnionFind(int size) {
        this.root = new int[size];
        this.rank = new int[size];
        
        //All the provinces are disconnected in the beginning
        this.count = size;
        
        //Initialize root and rank array
        for(int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    //Find using path compression optimization
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        
        return root[x] = find(root[x]);
    }
    
    //Union using union by rank optimization
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                //Both are equal set y's root as x; increase rootx's rank
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            //Decrease the number of province since now two independent provinces are joined (union)
            this.count--;   
        }
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    
    public int getProvinceCount() {
        return this.count;
    }
}
