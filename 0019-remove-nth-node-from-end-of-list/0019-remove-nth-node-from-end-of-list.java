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
        // Edge Case11
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;

        // Find size of LL
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        // Edge case2 (agr size n ke equal h to delete head)
        if(size==n){
            head=head.next;
            return head;
        }

        // Step1: move fast n steps
        while(n>0){
            fast=fast.next;
            n--;
        }

        // Step2: move slow and fast both 1 step
        // isme jb fast last index pr hoga tb slow target ke just piche hoga
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        // Deleting target node
        slow.next=slow.next.next;

        return head;
    }
}

// Optimal approach