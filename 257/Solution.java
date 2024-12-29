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
    public List<String> binaryTreePaths(TreeNode root) {
        return helper(root, new StringBuilder(), new ArrayList<>());
    }
    
    private List<String> helper(TreeNode root, StringBuilder currPath, List<String> answer) {
        //base case    
        if (root == null) {
            return answer;
        }

        //This variable is needed to know how many characters to remove for backtracking for e.g. need to remove 1 character if value of root is single digit, 2 character for double digit and so on
        int temp = currPath.length();

        //add to answer
        if (isLeaf(root)) {
            currPath.append(root.val);
            answer.add(currPath.toString());
            currPath.delete(temp, currPath.length());
        }

        //add
        currPath.append(root.val);
        currPath.append("->");

        //recurse
        helper(root.left, currPath, answer);
        helper(root.right, currPath, answer);

        //remove
        currPath.delete(temp, currPath.length());

        return answer;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}