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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode curr=head.next;
        int dist=2; //since curr exist at index 2

        ArrayList<Integer> li=new ArrayList<>();

        while(curr.next!=null){
            // Maxima check
            if(curr.val>prev.val && curr.val> curr.next.val){
                li.add(dist); //isme curr ka dis hi add hoga , kuki hm curr ke hisab se chala rhe h , dist ko 
            }
            // Minima check
            if(curr.val<prev.val && curr.val<curr.next.val){
                li.add(dist);
            }
            dist++;
            prev=prev.next;
            curr=curr.next;
        }
        // agr list ka size 3 se km h, to 2 critical point ho hi na sakte
        if(dist<=3){
            return new int[]{-1, -1};
        }
        // agr 1 ya ek se km critical points h
        if(li.size()<=1){
            return new int[]{-1, -1};
        }
        int maxDis=li.get(li.size()-1)-li.get(0);
        int minDis=Integer.MAX_VALUE;
        for(int i=1; i<li.size(); i++){
            int diff=li.get(i)-li.get(i-1);
            minDis=Math.min(minDis, diff);
        }

        return new int[]{minDis, maxDis};
    }
}