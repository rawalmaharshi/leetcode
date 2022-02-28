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
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // return bfs(root);
        if (root == null)   return new ArrayList<>();
        dfsHelper(root, 0);
        return levels;
    }
    
    public void dfsHelper(TreeNode root, int level) {
        //base case
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        
        //add root to levels 
        levels.get(level).add(root.val);
        if (root.left != null) {
            dfsHelper(root.left, level + 1);
        }
        
        if (root.right != null) {
            dfsHelper(root.right, level + 1);
        }
        
        return ;
    }
    
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> smallAns = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                smallAns.add(node.val);
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            answer.add(smallAns);
        }
        return answer;
    }
}