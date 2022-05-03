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
        //base case
        if (head == null) {
            return head;
        }
        
        //Save the nextNode in a temporary ListNode - recurse on this
        ListNode headNex = null;
        if (head.next != null) {
            headNex = head.next.next;
        }
        
        //swap head and next, continue to recurse further
        if (head.next != null) {
            //swap
            ListNode temp = head;
            head = head.next;
            head.next = temp;
        }
        
        if (head.next != null) {
            //recurse
            head.next.next = swapPairs(headNex);
        }
        
        return head;
    }
}