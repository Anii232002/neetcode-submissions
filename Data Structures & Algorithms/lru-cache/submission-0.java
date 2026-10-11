class LRUCache {

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        int value = map.get(key).val;
        insertNode(key);
        return value;
    }
    
    public void put(int key, int value) {
        if(map.size()==capacity && !map.containsKey(key)){
            Node rem = head.next;
            head.next = rem.next;
            rem.next.prev = head;
            map.remove(rem.key);
        }

        Node curr = null;
        if(map.containsKey(key)){
            curr = map.get(key);
            curr.val = value;
        }else{
            curr = new Node(key,value);
            map.put(key,curr);
        }

        insertNode(key);
    }

    private void insertNode(int key){

        Node curr = map.get(key);
        if(curr.prev!=null){
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        tail.prev.next = curr;
        curr.prev = tail.prev;

        tail.prev = curr;
        curr.next = tail;
    }
}

class Node {
    int val;
    int key;
    Node prev;
    Node next;

    Node(int key,int val){
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }

    Node(int val, Node prev, Node next){
        this.val = val;
        this.prev = prev;
        this.next = next;

    }
}
