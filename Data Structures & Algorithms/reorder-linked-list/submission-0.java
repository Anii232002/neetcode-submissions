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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)return ;
        ListNode head2 = new ListNode(-1);
        head2.next = head;
        ListNode slow = head2;
        ListNode fast = head2;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;
        while(fast!=null){
            ListNode tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }

        fast = head;

        while(fast!=null){
            ListNode fastNext = fast.next;
            ListNode slowNext = slow.next;
            fast.next = slow;
            slow.next = fastNext;
            fast = fastNext;
            slow = slowNext;
        }
        
        
     
    }
}
