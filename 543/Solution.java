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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //Get the longest path lengths from both left and right trees
        //add the max of two plus one (of root) as the answer
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        
        diameterHelper(root); 
        return max;
    }
    
    public int diameterHelper(TreeNode root) {
        //base case
        if (root == null) {
            return 0;   //No node found here, so 0
        }
        
        int leftPath = diameterHelper(root.left);
        int rightPath = diameterHelper(root.right);
        
        max = Math.max(max, leftPath + rightPath);
        
        return 1 + Math.max(leftPath, rightPath);
    }
}