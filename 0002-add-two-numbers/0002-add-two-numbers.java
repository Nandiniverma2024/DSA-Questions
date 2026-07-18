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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //mltb abi kisi bi index pe na h, pr java khud se 0 se initialize kr deti h
        ListNode dummy=new ListNode(-1); 

        ListNode curr=dummy;
        int carry=0;

        while(l1!=null || l2!=null || carry!=0){
            int x=0, y=0;

            // agr dono list khatam ho gi, sirf carry bacha h
            // to tb x and y ki default value 0 lenge 
            if(l1!=null){
                x=l1.val;
            }
            if(l2!=null){
                y=l2.val;
            }
            
            int sum=x+y+carry;
            carry=sum/10;
            int rem=sum%10; 

            // next node m rem dalo, jo sum se calculate hokr aaya h
            curr.next=new ListNode(rem); 

            curr=curr.next; //move curr pointer from dummy node to next current node


            // list pr sirf tbi traverse krnge, jb list exists krti ho
            if(l1!=null){
                l1=l1.next;
            }

            if(l2!=null){
                l2=l2.next;
            }
        }

        // while(l1!=null){

        // }

        return dummy.next;
    }
}