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
    public boolean isSymmetric(TreeNode root) {
        // return isSymmetric(root, root);
        return isSymmetric2(root, root);
    }
    
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        
        if (root1 == null || root2 == null) {
            return false;
        }
        
        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
    
    public boolean isSymmetric2(TreeNode r1, TreeNode r2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(r1);
        queue.offer(r2);
        
        while(!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            
            if (node1 == null && node2 == null) {
                continue;
            }
            
            if (node1 == null || node2 == null) {
                return false;
            }
            
            if (node1.val != node2.val) {
                return false;
            }
            
            //add comparison nodes
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        
        return true;
    }
}