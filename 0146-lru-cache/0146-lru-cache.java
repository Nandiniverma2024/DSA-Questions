class LRUCache {
    class Node{
        int key, value;
        Node prev, next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();

        head=new Node(-1, -1);
        tail=new Node(-1, -1);

        head.next=tail;
        tail.prev=head;
    }

    void remove(Node node){
        // head.next=tail;
        node.prev.next=node.next;
        // tail.prev=head;
        node.next.prev=node.prev;
    }
    
    void insert(Node node){
        // Make connection for nodes(changes head ki terms m aaynge)
        // 1. newNode.next=tail
        node.next=head.next;
        // 2. node.prev=head;
        node.prev=head;

        // Beak connection of head and tail
        // 1. tail.prev=newNode
        head.next.prev=node;
        // 2. head.next=newNode
        head.next=node;
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
        if(map.containsKey(key)){
            // overwrite already present key
            Node node=map.get(key);
            remove(node);
            node.value=value;
            insert(node);
        }else{
            if(map.size()==capacity){
                // head -> most recent used
                // tail -> least recent used
                Node lru=tail.prev;

                remove(lru);
                map.remove(lru.key);
            }

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