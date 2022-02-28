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
    public boolean isValidBST(TreeNode root) {
        return bstValidateHelper(root, null, null);
    }
    
    public boolean bstValidateHelper(TreeNode root, TreeNode low, TreeNode high) {
        //base case
        if (root == null) {
            return true;
        }
        
        if (low != null && low.val >= root.val) {
            return false;
        }
        
        if (high != null && high.val <= root.val) {
            return false;
        }
        
        return bstValidateHelper(root.left, low, root) && bstValidateHelper(root.right, root, high);
    }
    
    public boolean usingInOrder(TreeNode root) {
        //Make inorder; check if sorted
        List<Integer> inOrder = makeInOrder(root);
        for (int i = 0; i < inOrder.size() - 1; i++) {
            if (inOrder.get(i) >= inOrder.get(i + 1)) {
                return false;
            }
        }
            
        return true;
    }
    
    public List<Integer> makeInOrder(TreeNode root) {
        //base case
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> smallList = new ArrayList<>();
        smallList.addAll(makeInOrder(root.left));
        smallList.add(root.val);
        smallList.addAll(makeInOrder(root.right));
        return smallList;
    }
}