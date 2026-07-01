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
        if(head==null || head.next==null){
            return null;
        }
        head=reverse(head);
        if(n == 1){
            head = head.next;
            return reverse(head);
        }
        ListNode prev=head;
        ListNode curr=head.next;
        int idx=2;
        while(curr!=null){
            if(idx==n){
                prev.next=curr.next;
                break;
            }
            prev=curr;
            curr=curr.next;
            idx++;
        }
        head=reverse(head);
        return head;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;

            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}