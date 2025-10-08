// 141. Linked List Cycle
// Given head, the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
// Return true if there is a cycle in the linked list. Otherwise, return false.

 

// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

// Pattern : FAST AND SLOW POINTER(Floyd's Cycle-Finding Algorithm)

// Code: 
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Base Case: if no node exists or only one node exists that points to null that means no cycle is present, return false
        if(head==null || head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head; 
        while(fast !=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}



// TC -> O(N)
// SC -> O(1)
