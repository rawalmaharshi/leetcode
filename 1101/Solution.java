class Solution {
    public int earliestAcq(int[][] logs, int n) {
        //edge case
        if (logs.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        
        //Sort the logs array on timestamp since we need the earliest timestamp
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < logs.length; i++) {
            int timeStamp = logs[i][0];
            int x = logs[i][1], y = logs[i][2];
            uf.union(x, y);
            if (uf.isEveryoneAcquainted()) {
                return timeStamp;
            }
        }
        
        //Everyone is not yet acquainted
        return -1;
    }
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        int components;
        
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            components = size;
            
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
                    rank[rootX] += 1;
                }
                
                //Friendship formed; reduce component count
                components--;
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        
        public boolean isEveryoneAcquainted() {
            return this.components == 1;
        }
    }
}