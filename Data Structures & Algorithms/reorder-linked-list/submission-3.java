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

        if(head == null || head.next == null) return;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode slow = temp;
        ListNode fast = temp;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newSlow = slow.next;

        //make left last null
        slow.next = null;
        //move slow to right side
        slow = newSlow;
        //reverse second half starting from slow
        ListNode slowNext = slow.next;
        //make right side first's next point to null <- (right first) <- second last
        newSlow.next = null;

        System.out.println("slow at "+slow.val);

        while(slowNext!=null){
            ListNode next = slowNext.next;
            slowNext.next = slow;
            slow = slowNext;
            slowNext = next;
        }



        //now reorder

        ListNode left = head;
        ListNode right = slow;

        // System.out.println(" left = "+left.val+" right = "+right.val);

        while(left!=null && right!=null){
            ListNode temp1 = left.next;
            ListNode temp2 = right.next;
            left.next = right;
            right.next = temp1;
            left = temp1;
            right = temp2;
        }

    }
}
