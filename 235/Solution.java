class Solution {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hmHelper(root, null);
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        
        while (!set.contains(q)) {
            q = map.get(q);
        }
        
        return q;
    }
    
    public void hmHelper(TreeNode root, TreeNode parent) {
        //base case
        if (root == null) {
            return ;
        }
        
        map.put(root, parent);
        hmHelper(root.left, root);
        hmHelper(root.right, root);
        return ;
    }
}