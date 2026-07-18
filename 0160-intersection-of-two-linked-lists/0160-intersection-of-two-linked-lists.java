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
        ListNode pa=headA;
        ListNode pb=headB;

        while(pa!=pb){
            // agr pa khatam ho jay(end tak puch jay) to usa list "b" se chalana start kr do
            if(pa==null){
                pa=headB;
            }else{
                pa=pa.next;
            }
            // agr pb khatam ho jay(end tak puch jay) to usa list "a" se chalana start kr do
            if(pb==null){
                pb=headA;
            }else{
                pb=pb.next;
            }

            
        }

        return pa;
    }
}