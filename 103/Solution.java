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
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //edge case
        if (root == null) {
            return new ArrayList<>();
        }
        
        // return bfsHelper(root);
        dfsHelper(root, 0);
        return levels;
    }
    
    public void dfsHelper(TreeNode root, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        
        if (level % 2 == 0) {
            levels.get(level).add(root.val);
        } else {
            levels.get(level).add(0, root.val);
        }
        
        if (root.left != null) {
            dfsHelper(root.left, level + 1);
        }
        
        if (root.right != null) {
            dfsHelper(root.right, level + 1);
        }
        
        return ;
    }
    
    public List<List<Integer>> bfsHelper(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        boolean reverse = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> smallList = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (reverse)    smallList.add(0, node.val);
                else    smallList.add(node.val);
                
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(smallList);
            reverse = !reverse;
        }
        return list;
    }
}