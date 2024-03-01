class Solution {
    public boolean validTree(int n, int[][] edges) {
        //edge case
        if (edges.length != (n - 1)) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!uf.union(x, y)) {
                return false;
            }
        }
        
        //If we reached here, there are no cycles
        return true;
    }
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            
            return root[x] = find(root[x]);
        }
        
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                //Merged the two roots
                return true;
            }
            
            //Roots were same; no merge happened
            return false;
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}