// 707. Design Linked List
// Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
// A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
// If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

// Implement the MyLinkedList class:

// MyLinkedList() Initializes the MyLinkedList object.
// int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
// void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
// void addAtTail(int val) Append a node of value val as the last element of the linked list.
// void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
// void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

// Example 1:

// Input
// ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
// [[], [1], [3], [1, 2], [1], [1], [1]]
// Output
// [null, null, null, null, 2, null, 3]

// Explanation
// MyLinkedList myLinkedList = new MyLinkedList();
// myLinkedList.addAtHead(1);
// myLinkedList.addAtTail(3);
// myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
// myLinkedList.get(1);              // return 2
// myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
// myLinkedList.get(1);              // return 3





// Code
class MyLinkedList {
    // Globally define size and head
    private int size;
    private Node head;

    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;//initially linked list is null
        }
    }
    public MyLinkedList() {
        head=null;
        size=0; // Initially linked list is empty
    }
    
    public int get(int index) {
        if(index<0 || index>=size){ //if index=size , then it will go out of buond,eg-> size=3 , index=0,1,2 , =>3 hote hi out of bound ho jayga, kuki 3 el h na ki 4
            return -1;
        }
        Node currentNode=head;
        for(int i=0; i<index; i++){
            currentNode=currentNode.next;
        }
        return currentNode.val;
    }
    
    public void addAtHead(int val) {
        Node newNode=new Node(val);
        newNode.next=head;
        head=newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
        }else{
            Node currentNode=head;
            while(currentNode.next != null){
                currentNode=currentNode.next;
            }
            currentNode.next=newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>size){
            return;
        }
        if(index==0){
            addAtHead(val);//agar koi node nhi h , to add newNode
            return;
        }
        Node newNode=new Node(val);
        Node currentNode=head;
        for(int i=0; i<index-1; i++){
            currentNode=currentNode.next;
        }
        // 1. Build connection of newNode and node present at index+1
        // 2. Build connection with index-1 node with newNode
        newNode.next=currentNode.next;
        currentNode.next=newNode;
        
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size || head==null){
            return;
        }
        if(index==0){
            head=head.next;//if only 1 node present(mltb index 0 pr present hoga vo node) , then delete that single node
        }else{
            Node currentNode=head;
            for(int i=0; i<index-1; i++){
                currentNode=currentNode.next;
            }
            currentNode.next=currentNode.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


