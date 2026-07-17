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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode mid=findMid(head);

        ListNode leftHead=head;
        ListNode rightHead=mid.next;

        mid.next=null;

        ListNode left=sortList(leftHead);
        ListNode right=sortList(rightHead);

        return mergeLL(left, right);
    }

    public ListNode mergeLL(ListNode left, ListNode right){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(left!=null && right!=null){

            if(left.val<=right.val){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }else if(left.val>right.val){
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }

        while(left!=null){
            temp.next=left;
            left=left.next;
            temp=temp.next;
        }

        while(right!=null){
            temp.next=right;
            right=right.next;
            temp=temp.next;
        }

        return dummy.next;
    }
    public ListNode findMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next; //for even list(take 1st mid)
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}