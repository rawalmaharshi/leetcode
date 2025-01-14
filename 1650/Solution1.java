/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p2 = p, q2 = q;

        while (p2 != q2) {
            p2 = p2 == null ? q : p2.parent;
            q2 = q2 == null ? p : q2.parent;
        }

        return p2;
    }
}