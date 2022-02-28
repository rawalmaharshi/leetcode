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
    public int minDepth(TreeNode root) {
        //edge case
        if (root == null) {
            return 0;
        }
        
        //base case
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        int leftDepth = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int rightDepth = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);
        
        return 1 + Math.min(leftDepth, rightDepth);
    }
}