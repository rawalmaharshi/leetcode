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
    int maxDepth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        // return dfs(root);
        return bfs(root);
    }

    private int dfs(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }

        //edge case
        if (root.left == null && root.right == null) {
            return 1;
        }

        maxDepthHelper(root);
        return maxDepth;
    }

    private int maxDepthHelper(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepthHelper(root.left);
        int rightDepth = maxDepthHelper(root.right);

        maxDepth = Math.max(maxDepth, 1 + Math.max(leftDepth, rightDepth));

        return 1 + Math.max(leftDepth, rightDepth);
    }

    private int bfs(TreeNode root) {
        //edge case
        if (root == null) {
            return 0;
        }

        int numLevels = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            numLevels++;
        }


        return numLevels;
    }
}