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
    public List<Integer> rightSideView(TreeNode root) {
        // return bfs(root);
        return dfs(root, 0, new ArrayList<>());
    }

    public List<Integer> dfs(TreeNode root, int level, List<Integer> answer) {
        //base case
        if (root == null) {
            return answer;
        }

        //set the element at that level
        if (level == answer.size()) {
            answer.add(root.val);
        } else {
            answer.set(level, root.val);
        }

        //left and right subcalls
        dfs(root.left, level + 1, answer);
        dfs(root.right, level + 1, answer);

        return answer;
    }

    public List<Integer> bfs(TreeNode root) {
        //edge case
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //add to answer only if its the rightmost node
                if (i == (size - 1)) {
                    answer.add(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return answer;
    }
}