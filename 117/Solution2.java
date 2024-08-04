/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Node prev, leftmost;

    public void processChild(Node child) {
        if (child != null) {
            if (prev != null) {
                prev.next = child;
            } else {
                leftmost = child;
            }

            prev = child;
        }
    }

    public Node connect(Node root) {
        //edge case
        if (root == null) {
            return root;
        }

        leftmost = root;
        Node curr = leftmost;

        //Dont know tree's structure, will stop at the last level - no children
        while(leftmost != null) {
            //prev latest node on next level, curr latest node on current level
            prev = null;
            curr = leftmost;

            leftmost = null;

            while(curr != null) {
                processChild(curr.left);
                processChild(curr.right);

                curr = curr.next;
            }
        }

        return root;
    }
}