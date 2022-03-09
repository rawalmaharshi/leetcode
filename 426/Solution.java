/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        //edge case
        if (root == null) {
            return root;
        }
        
        helper(root);
        last.right = first;
        first.left = last;
        
        return first;
    }
    
    //Perform an inorder traversal here and set pointers
    public void helper(Node node) {
        //base case
        if (node == null) {
            return ;
        }
        
        //call left child
        helper(node.left);
        
        //Set pointer
        if (last == null) {
            first = node;
        } else {
            //set left and right child
            last.right = node;
            node.left = last;
        }
        last = node;
        
        //call right child
        helper(node.right);
    }
}