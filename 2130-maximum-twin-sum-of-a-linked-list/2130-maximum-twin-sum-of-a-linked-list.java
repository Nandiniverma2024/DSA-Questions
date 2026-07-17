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
    public int pairSum(ListNode head) {
        // Find Mid
        ListNode mid=findMid(head);

        ListNode curr=mid.next;

        // break the list
        mid.next=null;

        // Reverse next half
        ListNode revHead=reverse(curr);

        int maxSum=Integer.MIN_VALUE;

        while(head!=null && revHead!=null){
            int sum=head.val + revHead.val;
            maxSum=Math.max(maxSum, sum);

            head=head.next;
            revHead=revHead.next;
        }

        return maxSum;

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