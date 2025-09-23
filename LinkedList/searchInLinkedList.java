// Search in Linked List
// Difficulty: EasyAccuracy: 65.4%Submissions: 117K+Points: 2Average Time: 10m
// Given a linked list with the head node and a key, the task is to check if the key is present in the linked list or not. Return true if key is present, else return false.

// Example:
// Input: key = 3,
      
// Output: true
// Explanation: 3 is present in Linked List.


// PATTERN -> Linked List Linear Search(or traversal)

// Code: 
class Solution {
    public boolean searchKey(Node head, int key) {
        Node currNode=head;
        while(currNode != null){
            if(currNode.data==key){
                return true;
            }
            currNode=currNode.next;
        }
        return false;
    }
}


// TC -> O(n)
// SC -> O(1)


