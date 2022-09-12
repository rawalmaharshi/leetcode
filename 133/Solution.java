/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // return usingDFS(node, new HashMap<Node, Node>());
        return usingBFS(node);
    }
                     
    public Node usingDFS(Node node, Map<Node, Node> cloneMap) {
        //base case
        if (node == null) {
            return null;
        }
        
        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }
        
        Node cloneNode = new Node(node.val, new ArrayList<>());
        cloneMap.put(node, cloneNode);
        
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(usingDFS(neighbor, cloneMap));
        }
        
        return cloneNode;
    }

    public Node usingBFS(Node node) {
        //edge case
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> cloneMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        cloneMap.put(node, new Node(node.val, new ArrayList<>()));
        
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            for (Node neighbor : currNode.neighbors) {
                if (!cloneMap.containsKey(neighbor)) {
                    cloneMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
            cloneMap.get(currNode).neighbors.add(cloneMap.get(neighbor));
            }
        }
            
        return cloneMap.get(node);
     }
}