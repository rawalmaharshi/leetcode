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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            while (node != null) {
                pq.offer(node);
                node = node.next;
            }
        }
        
        ListNode head = null;
        ListNode tail = null;
        
        while(!pq.isEmpty()) {
            if (head == null) {
                head = pq.poll();
                // System.out.println(head.val);
                tail = head;
            } else {
                tail.next = pq.poll();
                // System.out.println(tail.next.val);
                tail = tail.next;
            }
        }
        
        if (tail != null)
            tail.next = null;
        
        return head;
    }
    
    public int minIndex (ListNode[] lists) {
        int minIndex = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i].val < min) {
                min = lists[i].val;
                minIndex = i;
            }
        }
        return minIndex;
    }
}