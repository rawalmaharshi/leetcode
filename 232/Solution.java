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
    public int kthSmallest(TreeNode root, int k) {
        //using pq
        return usingPQ(root, k);
        
        //First create an inorder traversal of the tree (which is sorted in case of BST), then just find kth elem
//         List<Integer> elems = findOrder(root);
        
//         int answer = 0;
//         for (int i : elems) {
//             if ((--k) == 0) {
//                 answer = i;
//             }
//         }
            
//         return answer;
    }
    
    public List<Integer> findOrder(TreeNode root) {
        //base case
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> smalList = new ArrayList<>();
        smalList.addAll(findOrder(root.left));
        smalList.add(root.val);
        smalList.addAll(findOrder(root.right));
        
        return smalList;
    }
    
    public int usingPQ(TreeNode root, int k) {
        //edge case
        if (root == null) {
            return 0;
        }
        
        PriorityQueue<TreeNode> pq = new PriorityQueue<>((a,b) -> b.val - a.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            pq.offer(curr);
            if (pq.size() > k) {
                pq.poll();
            }
            if (curr.left != null)  queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return pq.peek().val;
    }
}