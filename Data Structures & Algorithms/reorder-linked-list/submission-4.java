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
    // TC : O(N)
    // SC : O(1)
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverseHead = reverse(slow.next);
        slow.next = null;
        ListNode forwardHead = head;
        while(forwardHead != null && reverseHead != null) {
            ListNode forwardNext = forwardHead.next;
            ListNode reverseNext = reverseHead.next;

            forwardHead.next = reverseHead;
            reverseHead.next = forwardNext;

            forwardHead = forwardNext;
            reverseHead = reverseNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head, previous = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
