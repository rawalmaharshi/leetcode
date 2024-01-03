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
    int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //map to retrieve index of root in inorder array faster
        Map<Integer, Integer> inorderMap = new HashMap<>();
        int length = inorder.length;
        //Set (GLOBAL) postorderIndex as the index of last element 
        postorderIndex = length - 1;

        for (int i = 0; i < length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, inorderMap, 0, length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, Map<Integer, Integer> inorderMap, int left, int right) {
        //base case
        if (left > right) {
            return null;
        }
        
        //set rootval from postorderIndex and decrease it
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        //left and right subcalls 
        //CREATING RIGHT SUBTREE FIRST
        root.right = arrayToTree(postorder, inorderMap, inorderMap.get(rootVal) + 1, right);
        root.left = arrayToTree(postorder, inorderMap, left, inorderMap.get(rootVal) - 1);
        
        return root;
    }
}