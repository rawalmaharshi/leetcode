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
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSumHelper(root, targetSum, new ArrayList<>());
        return answer;
    }

    private void pathSumHelper(TreeNode root, int remainingSum, List<Integer> currList) {
        //targetSum not possible
        if (root == null) {
            return ;
        }

        //add
        currList.add(root.val);

        //add to answer
        if (root.left == null && root.right == null && remainingSum == root.val) {
            answer.add(new ArrayList<>(currList));
        }

        //recurse (left, right subcalls)
        pathSumHelper(root.left, remainingSum - root.val, currList);
        pathSumHelper(root.right, remainingSum - root.val, currList);

        //remove
        currList.remove(currList.size() - 1);

        return ;
    }
}