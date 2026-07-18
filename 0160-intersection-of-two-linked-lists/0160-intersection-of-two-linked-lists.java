/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA=sizeLL(headA);
        int sizeB=sizeLL(headB);
        int diff=Math.abs(sizeA-sizeB);

        ListNode pa=headA;
        ListNode pb=headB;

        if(sizeA>sizeB){
            while(sizeA>sizeB && diff>0){
                pa=pa.next;
                diff--;
            }
        }else{
            while(sizeB>sizeA && diff>0){
                pb=pb.next;
                diff--;
            }
        }
        
        while(pa!=null && pa!=null){
            if(pa==pb){
                return pa;
            }

            pa=pa.next;
            pb=pb.next;
        }

        return null;
    
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