class Solution {
    class Pair{
        int num;
        int idx;
        Pair(int num, int idx){
            this.num=num;
            this.idx=idx;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int left=0, right=0;
        // Total windows => n-k+1
        int res[]=new int[n-k+1];
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b) -> b.num - a.num);
        
        while(right<n){
            pq.offer(new Pair(nums[right], right));
            if(right-left+1 < k){
                right++;
            }else if(right-left+1 == k){
                // Form a desending order queue
                while(!pq.isEmpty() && pq.peek().idx < left){
                    pq.poll();
                }
                res[left]=pq.peek().num;
                
                left++;
                right++;
            }
        }

        return res;
    }
}