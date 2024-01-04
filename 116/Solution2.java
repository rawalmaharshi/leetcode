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
  public Node connect(Node root) {
      // return bfs(root);
      return constantSpace(root);
  }

  public Node constantSpace(Node root) {
      //base case
      if (root == null) {
          return root;
      }

      Node leftMost = root;

      while (leftMost.left != null) {
          //Iterate from left to right like a LinkedList
          Node head = leftMost;
          while (head != null) {
              //left child to right child relationship
              head.left.next = head.right;

              //relationship b/w nodes that dont share parent (visualize)
              if (head.next != null) {
                  head.right.next = head.next.left;
              }
              
              head = head.next;
          }
          leftMost = leftMost.left;
      }

      return root;
  }
  
  private Node bfs(Node root) {
      //edge case
      if (root == null) {
          return root;
      }
      
      Queue<Node> queue = new LinkedList<>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          for (int i = 0; i < size; i++) {
              Node node = queue.poll();
              //point to next node in the queue; queue.peek() returns null in case queue is empty
              if (i == (size - 1)) {
                  node.next = null;
              } else {
                  node.next = queue.peek();
              }
              
              if (node.left != null)  queue.offer(node.left);
              if (node.right != null) queue.offer(node.right);
          }
      }
      
      return root;
  }
}