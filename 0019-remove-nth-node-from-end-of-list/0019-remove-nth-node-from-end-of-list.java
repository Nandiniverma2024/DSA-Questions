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
        // Edge Case
        if(head==null || head.next==null){
            return null;
        }
        // nthNode => size-n+1 (from begining for 0 based indexing)
        int prevNthNode=sizeLL(head)-n;

        if(n==sizeLL(head)){
            head=head.next;
        }
        
        ListNode temp=head;
        int len=1;
        while(temp!=null && temp.next!=null){
            if(len==prevNthNode){
                temp.next=temp.next.next;
            }
            len++;
            temp=temp.next;
        }
        return head;
    }
    public int sizeLL(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}