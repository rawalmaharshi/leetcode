class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            int x = pair.get(0), y = pair.get(1);
            uf.union(x, y);
        }

        //Map to store root -> all vertices of the root
        Map<Integer, List<Integer>> rootMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int currentRoot = uf.find(i);
            rootMap.putIfAbsent(currentRoot, new ArrayList<>());
            rootMap.get(currentRoot).add(i);
        }

        // Answer
        char[] answer = new char[s.length()];

        //Iterate over hashmap
        for (int root : rootMap.keySet()) {
            List<Integer> connectedIndices = rootMap.get(root);

            //Characters array to store and sort chars at those indices
            List<Character> characters = new ArrayList<>();
            for (int index : connectedIndices) {
                characters.add(s.charAt(index));
            }

            //Sort
            Collections.sort(characters);

            //Set indices in answer
            for (int i = 0; i < connectedIndices.size(); i++) {
                answer[connectedIndices.get(i)] = characters.get(i);
            }
        }

        return new String(answer);
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
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}