class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //edge case
        if (n < 2) {
            List<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                centroids.add(i);
            }
            return centroids;
        }

        //Create graph
        List<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        //Initialize 1st layer of leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (neighbors.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        //Trim the leaves until reaching the centroids
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            //remove the current leaves along with the edges
            for (int leaf : leaves) {
                //the only neighbor left for the leaf node
                Integer neighbor = neighbors.get(leaf).iterator().next();

                //remove the edge along with the leaf node
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            //prepare for next round
            leaves = newLeaves;
        }

        //The remaining nodes are the centroids of the graph
        return leaves;
    }
}