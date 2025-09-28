// 876. Middle of the Linked List
// Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.

 
// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.


// PATTERN : FAST AND SLOW POINTER


// CODE: 
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // we need to check 2 things, jb tak last node pr na puch jay(mlt fast.next==null) + fast pointer 2 step move krte hua , list ke end se aage na nikal jay
        while(fast != null && fast.next != null){
            // slow=> move 1 step , fast=> moves 2 step 
            // fast != null, mltb fast pointer list ke end se aage nhi gya
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; // When loop ends, slow points to middle node
    }
}


// TC=O(n), Total iterations: approximately n/2 (n = number of nodes in list)
// SC=O(1)

