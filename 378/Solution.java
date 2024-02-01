class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxPQ.offer(matrix[i][j]);
                if (maxPQ.size() > k) {
                    maxPQ.poll();
                }
            }
        }
        
        return maxPQ.peek();
    }
}