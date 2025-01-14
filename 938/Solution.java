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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high, 0);
    }

    private int helper(TreeNode root, int low, int high, int sum) {
        //base case
        if (root == null) {
            return sum;
        }

        //left and right subcalls (using bst property)
        int leftSum = 0, rightSum = 0;
        if (root.val > low) {
            leftSum = helper(root.left, low, high, sum);
        }
        
        if (root.val < high) {
            rightSum = helper(root.right, low, high, sum);
        }
        

        //add to sum the value of root if in range
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        sum += leftSum + rightSum;

        return sum;
    }
}

/*
    Algo:
    1. Bottom-up recursion - solve for subproblem first
    2. Do a dfs traversal
    3. Call left and right depending on bst's property
    Time Complexity: O(n)
    Space Complexity: O(n) - recursive stack
 */