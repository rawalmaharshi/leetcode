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
        //edge case
        if (root == null) {
            return new ArrayList<>();
        }
        
        //BFS
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                if (i == (queueSize - 1)) { //rightmost element
                    answer.add(curr.val);
                }
                
                if (curr.left != null)  queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return answer;
    }
}


class Solution {
    List<Integer> answer = new ArrayList<>(); 
    public List<Integer> rightSideView(TreeNode root) {
        //edge case
        if (root == null) return answer;
        dfsHelper(root, 0);
        return answer;
    }
    
    public void dfsHelper(TreeNode root, int level) {
        if (level == answer.size())
            answer.add(root.val);
        
        if (root.right != null) {
            dfsHelper(root.right, level + 1);
        }
        
        if (root.left != null) {
            dfsHelper(root.left, level + 1);
        }
    }
}