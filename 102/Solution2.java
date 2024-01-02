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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // return bfs(root);
        return dfs(root, 0, new ArrayList<>());
    }

    public List<List<Integer>> dfs(TreeNode root, int level, List<List<Integer>> answer) {
        //base case
        if (root == null) {
            return answer;
        }

        //first node in that level
        if (level == answer.size()) {
            List<Integer> smallAns = new ArrayList<>();
            smallAns.add(root.val);
            answer.add(smallAns);
        } else {
            //subsequent nodes at that level
            answer.get(level).add(root.val);
        }

        //left and right subcalls
        dfs(root.left, level + 1, answer);
        dfs(root.right, level + 1, answer);

        return answer;
    }

    public List<List<Integer>> bfs(TreeNode root) {
        //edge case
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> smallAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //add to level
                smallAns.add(node.val);
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            answer.add(smallAns);
        }

        return answer;
    }
}