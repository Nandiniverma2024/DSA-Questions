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
    public boolean isPalindrome(ListNode head) {
        ListNode mid=findMid(head);

        ListNode secListHead=mid.next;
        mid.next=null;

        ListNode revHead=reverse(secListHead);

        while(head!=null && revHead!=null){
            if(head.val!=revHead.val){
                return false;
            }
            head=head.next;
            revHead=revHead.next;
        }

        return true;
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

    public ListNode findMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}