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
    int maxDepth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }

        //edge case
        if (root.left == null && root.right == null) {
            return 1;
        }

        maxDepthHelper(root);
        return maxDepth;
    }

    private int maxDepthHelper(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepthHelper(root.left);
        int rightDepth = maxDepthHelper(root.right);

        maxDepth = Math.max(maxDepth, 1 + Math.max(leftDepth, rightDepth));

        return 1 + Math.max(leftDepth, rightDepth);
    }
}