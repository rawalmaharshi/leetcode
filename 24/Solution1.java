/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }
    
    private ListNode helper(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        
        //swap nodes
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        
        firstNode.next = helper(secondNode.next);
        secondNode.next = firstNode;
        
        return secondNode;
    }
}