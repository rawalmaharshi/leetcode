/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<>();
        //edge case
        if (root == null) {
            return answer;
        }
        
        //Level order traversal - BFS
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> smallAnswer = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                Node node = queue.poll();
                smallAnswer.add(node.val);
                
                //add all children to queue for bfs
                queue.addAll(node.children);
            }
            answer.add(smallAnswer);
        }
        
        return answer;
    }
}