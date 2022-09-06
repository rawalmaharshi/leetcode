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
    public ListNode middleNode(ListNode head) {
        // return usingLength(head);
        return usingSlowAndFastPointer(head);
    }
    
    public ListNode usingSlowAndFastPointer(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
            
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode usingLength(ListNode head) {
        int length = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            tempHead = tempHead.next;
            length++;
        }
        
        int mid = length/2;
        while (mid-- > 0) {
            head = head.next;
        }
        
        return head;
    }
}