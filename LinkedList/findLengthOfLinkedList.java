// Find Length of Linked List
// Difficulty: BasicAccuracy: 85.99%Submissions: 271K+Points: 1Average Time: 15m
// Given head of a singly linked list. The task is to find the length of the linked list, where length is defined as the number of nodes in the linked list.

// Examples :
// Input: head : 1->2->3->4->5

// Output: 5
// Explanation: Length of the linked list is 5, as there 
// are 5 nodes present in it.



// PATTERN -> Linked List Traversal

// Code
class Solution {
    public int getCount(Node head) {
        int count=0;
        Node currNode=head;
        while(currNode.next != null){
            currNode=currNode.next;
            count++;
        }
        return count+1;// for counting last node, jiska next null hoga
    }
}

// TC -> O(n)
// SC -> O(1)

