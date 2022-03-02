class Solution {
    public int removeStones(int[][] stones) {
        //edge case
        if (stones == null || stones.length == 0) {
            return 0;
        }
        
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int[] stone1 = stones[i];
            for (int j = i + 1; j < n; j++) {
                int[] stone2 = stones[j];
                //same row or column
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1])
                    uf.union(i, j);
            }
        }
        
        return n - uf.getcount();
    }
}

class UnionFind {
    int[] root;
    int[] rank;
    int count;
    
    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;
        
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        
        return root[x] = find(root[x]);    //Path Compression
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
            count--;
        }
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }   
    
    public int getcount() {
        return count;
    }
}