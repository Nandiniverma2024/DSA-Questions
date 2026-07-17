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
    public ListNode oddEvenList(ListNode head) {
        // edge cae
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;

        // Store starting node of even list
        ListNode evenHead=head.next; //jisse even ka head miss na ho jay

        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            odd=odd.next;

            even.next=even.next.next;
            even=even.next;
        }
       
        // attach even list after odd list
        odd.next=evenHead;

        // if we do odd.next=even.next => to ye 4 ko point krega
        // but if we do odd.next=evenHead => to ye 2 ko point krega in example 1

        return head;
    }
}