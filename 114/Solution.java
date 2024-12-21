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
 *         this.left = left;sv
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode flattenHelper(TreeNode root) {
        //edge case
        if (root == null) {
            return null;
        }

        //Leaf node - return as such
        if (root.left == null && root.right == null) {
            return root;
        }

        //Recursive flatten left subtree
        TreeNode leftTail = flattenHelper(root.left);

        //Recursive flatten right rubtree
        TreeNode rightTail = flattenHelper(root.right);

        //Make the connections from left -> right 
        //Set left to null
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        //return rightmost node
        return rightTail == null ? leftTail : rightTail;
    }

    private void morrisTraversal(TreeNode root) {
        //edge case
        if (root == null) {
            return ;
        }

        while (root != null) {
            //if there is a left child
            if (root.left != null) {
                //find the rightmost node
                TreeNode rightMost = root.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                //rewire connections
                rightMost.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            //move to the right side of the tree
            root = root.right;
        }
    }

    public void flatten(TreeNode root) { 
        // flattenHelper(root);   // T: O(N), S: O(N)
        morrisTraversal(root);  //T: O(N), S: O(1)
    }
}