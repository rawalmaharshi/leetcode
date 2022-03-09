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
    public List<Integer> rightSideView(TreeNode root) {
        // return usingDFS(root);
        return usingBFS(root);
    }
    
    private List<Integer> usingBFS(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                
                if (i == (queueSize - 1)) {
                    answer.add(curr.val);
                }
                
                if (curr.left != null)  queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        
        return answer;
    }
    
    private List<Integer> usingDFS(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        //edge case
        if (root == null) {
            return answer;
        }
        
        dfsHelper(root, 0, answer);
        return answer;
    }
    
    private void dfsHelper(TreeNode root, int depth, List<Integer> answer) {
        //base case
        if (root == null) {
            return ;
        }
        
        //Add root to the depth(index) in answer list
        if (answer.size() == depth) {
            answer.add(root.val);
        }
        
        //Right side view
        dfsHelper(root.right, depth + 1, answer);
        
        //Calling left in case it's a left skewed tree
        dfsHelper(root.left, depth + 1, answer);
        
        return ;
    }
}