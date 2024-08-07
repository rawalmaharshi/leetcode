/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return recursive(root, p, q);
        return iterative(root, p, q);
    }

    public TreeNode iterative(TreeNode root, TreeNode p, TreeNode q) {
        //edge case
        if (root == null) {
            return root;
        }

        TreeNode node = root;
        while (node != null) {
            //search left part of binary tree
            if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else if (node.val < p.val && node.val < q.val) {
                //search right part of binary tree
                node = node.right;
            } else {
                break;
            }

        }

        return node;
    }

    public TreeNode recursive(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null) {
            return root;
        }

        //search left part of binary tree
        if (root.val > p.val && root.val > q.val) {
            return recursive(root.left, p, q);
        }

        //search right part of binary tree
        if (root.val < p.val && root.val < q.val) {
            return recursive(root.right, p, q);
        }

        return root;
    }
}