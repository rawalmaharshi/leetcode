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
    int answer = 0;
    public int countUnivalSubtrees(TreeNode root) {
        univalHelper(root);
        return answer;
    }
    
    private boolean univalHelper(TreeNode root) {
        //base case
        if (root == null) {
            return true;
        }
        
        boolean isLeftUnival = univalHelper(root.left);
        boolean isRightUnival = univalHelper(root.right);

        if (isLeftUnival && isRightUnival) {
            if (root.left != null && root.left.val != root.val) {
                return false;
            }

            if (root.right != null && root.right.val != root.val) {
                return false;
            }

            answer++;
            return true;
        }

        //if left and right subtrees are not unival, return false
        return false;
    }
}