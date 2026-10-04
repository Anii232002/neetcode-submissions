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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head==null)return head;

       ListNode slow = head;
       int count = 0;
       while(slow!=null){
            count ++; 
            slow = slow.next;
       }

       n = count - n;

       ListNode temp = new ListNode(0);
       temp.next = head;

       slow = temp;
       ListNode fast = head;
       
       while(fast!=null && n!=0){
            slow = slow.next;
            fast = fast.next;
            n--;
       }

       slow.next = fast.next;
       
       return temp.next;


    }
}
