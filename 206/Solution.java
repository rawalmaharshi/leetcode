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
    ListNode answer = null;
    public ListNode reverseList(ListNode head) {
        // return iterative(head);
        recursive(null, head);
        return answer;
    }
    
    public void recursive(ListNode prev, ListNode head) {
        //base case
        if (head == null) {
            answer = prev;  //this is the node which is the new head of the reversed list
            return ;
        }
        
        recursive(head, head.next);
        head.next = prev;
        return ;
    }
    
    public ListNode iterative (ListNode head) {
        ListNode prev = null, nex = null;
        while (head != null) {
            nex = head.next;
            head.next = prev;
            prev = head;
            head = nex;
        }
        
        return prev;
    }
}