/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node curr = head;
        int i = 0;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }
        curr = head;

        while(curr != null){
            Node next =  map.get(curr.next);
            Node random = map.get(curr.random);
            Node newCurr = map.get(curr);
            newCurr.next = next;
            newCurr.random = random;
            curr = curr.next;
        }



        return map.get(head);
    }
}
