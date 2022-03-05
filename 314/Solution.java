/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // return usingHashmap(root);
        return usingHashmapNoSort(root);
    }
    
    public List<List<Integer>> usingHashmap(TreeNode root) {
        //edge case
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // bfs
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode curr = p.node;
            int colIndex = p.colIndex;
            if (!map.containsKey(colIndex)) {
                map.put(colIndex, new ArrayList<Integer>());
            }
            map.get(colIndex).add(curr.val);
            
            if (curr.left != null)  queue.offer(new Pair(curr.left, colIndex - 1));
            if (curr.right != null) queue.offer(new Pair(curr.right, colIndex + 1));
        }
        
        //Sort hashmap on keys
        List<Integer> keys = new ArrayList<Integer>(map.keySet());
        Collections.sort(keys);
        
        for (int key : keys) {
            answer.add(map.get(key));
        }
        
        return answer;
    }
    
    public List<List<Integer>> usingHashmapNoSort(TreeNode root) {
        //edge case
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // bfs
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int minColumn = 0, maxColumn = 0;
        
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode curr = p.node;
            int colIndex = p.colIndex;
            if (!map.containsKey(colIndex)) {
                map.put(colIndex, new ArrayList<Integer>());
            }
            map.get(colIndex).add(curr.val);
            
            if (curr.left != null)  queue.offer(new Pair(curr.left, colIndex - 1));
            if (curr.right != null) queue.offer(new Pair(curr.right, colIndex + 1));
            
            //calculate min and max column so that in the end we don't need to sort keys
            minColumn = Math.min(minColumn, colIndex);
            maxColumn = Math.max(maxColumn, colIndex);
        }
        
        for (int i = minColumn; i <= maxColumn; i++) {
            answer.add(map.get(i));
        }
        
        return answer;
    }
}

class Pair {
    TreeNode node;
    int colIndex;
    
    Pair (TreeNode node, int index) {
        this.node = node;
        colIndex = index;
    }
}