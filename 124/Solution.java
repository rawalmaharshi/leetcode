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
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathHelper(root);
        return maxPathSum > root.val ? maxPathSum : root.val;
    }
    
    public int pathHelper(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }
        
        int leftPathSum = Math.max(pathHelper(root.left), 0);
        int rightPathSum = Math.max(pathHelper(root.right), 0);
    
        int currentPathSum = root.val + leftPathSum + rightPathSum;

        maxPathSum = Math.max(maxPathSum, currentPathSum);
        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}