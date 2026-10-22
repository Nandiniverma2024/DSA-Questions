class LRUCache {
    class Node{
        int key, value;
        Node prev, next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    // Declare
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        // Initialize
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(-1, -1);
        tail=new Node(-1, -1);

        // Connection Establish
        head.next=tail;
        tail.prev=head;
    }

    public void insert(Node node){
        node.next=head.next;
        node.prev=head;


        head.next.prev=node;
        head.next=node;
        
    }
    public void remove(Node node){
        // head -> tial
        node.prev.next=node.next;
        // head <- Tail
        node.next.prev=node.prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);

            remove(node);

            insert(node);

            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // 1. if key present in map
        if(map.containsKey(key)){
            Node node=map.get(key);

            node.value=value; //overwrite value

            remove(node);
            insert(node);

            map.put(key, node);
        }
        // 2. if key not present in map
        else{
            // i. if capacity is full
            if(map.size()==capacity){
                Node lru=tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            // ii. if capacity is not full
            Node node=new Node(key, value);
            insert(node);
            map.put(key, node);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */