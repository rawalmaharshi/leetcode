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
        // recursive(null, head);
        // return answer;
        return recursive2(head);
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

    public void recursive2 (ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode reversed = recursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return reversed;
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