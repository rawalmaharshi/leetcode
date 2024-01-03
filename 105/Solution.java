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
    int preorderIndex = 0;  //Keep this as global otherwise it will try to overwrite existing value during recursion call resulting in IndexOutOfBoundsException
    //Dry run to see why
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Create inOrder hashmap for faster root element index retrieval
        Map<Integer, Integer> inorderMap = new HashMap<>();
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, inorderMap, 0, length - 1);
    }

    public TreeNode arrayToTree(int[] preorder, Map<Integer, Integer> inorderMap, int left, int right) {
        //base case (no elements to contruct tree)
        if (left > right) {
            return null;
        }

        //preorder array will have root values in order
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        //left and right subcalls
        root.left = arrayToTree(preorder, inorderMap, left, inorderMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, inorderMap, inorderMap.get(rootVal) + 1, right);

        return root;
    }
}