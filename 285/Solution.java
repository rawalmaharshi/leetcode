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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // return usingInorder(root, p);
        return usingBST(root, p);
    }

    public TreeNode usingBST(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.val >= root.val) {
                //discard left subtree
                root = root.right;
            } else {
                //discard right subtree
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
    
    private TreeNode usingInorder(TreeNode root, TreeNode p) {
        List<TreeNode> inorder = createInorder(root, new ArrayList<>());
        int indexOfP = inorder.indexOf(p);
        
        return indexOfP == inorder.size() - 1 ? null : inorder.get(indexOfP + 1);
    }

    private List<TreeNode> createInorder(TreeNode root, List<TreeNode> inorder) {
        //base case
        if (root == null) {
            return inorder;
        }
        
        createInorder(root.left, inorder);
        inorder.add(root);
        createInorder(root.right, inorder);
        
        return inorder;
    }
}