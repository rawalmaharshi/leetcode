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
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //return usingParent(root, p, q);
        return withoutParent(root, p, q);
    }
    
    public TreeNode withoutParent(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        
        TreeNode left = withoutParent(root.left, p, q);
        TreeNode right = withoutParent(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    public TreeNode usingParent(TreeNode root, TreeNode p, TreeNode q) {
        //create a child-parent relationship
        parentHelper(root, null);

        //Create a HashSet to check if the parent value is already added to it, if it is thats our LCA
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parentMap.get(p);
        }
        
        while (!set.contains(q)) {
            q = map.get(q);
        }
        
        return q;
    }
    
    public void parentHelper(TreeNode root, TreeNode parent) {
        //base case
        if (root == null) {
            return ;
        }
        
        parentMap.put(root, parent);
        parentHelper(root.left, root);
        parentHelper(root.right, root);
        
        return ;
    }
}