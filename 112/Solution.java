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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfsHelper(root, targetSum);
    }
    
    public boolean dfsHelper(TreeNode root, int targetSum) {
        //base case
        if (root == null) {
            return false;
        }
        
        if (root.val == targetSum && (root.left == null && root.right == null)) {
            return true;
        }
        
        return dfsHelper(root.left, targetSum - root.val) || dfsHelper(root.right, targetSum - root.val);
    }
}