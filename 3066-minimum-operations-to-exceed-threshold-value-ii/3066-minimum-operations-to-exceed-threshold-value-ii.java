class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.offer((long)nums[i]);
        }

        int cnt=0;
        while(pq.peek()<k){
            long x=pq.poll();
            long y=pq.poll();
            pq.offer((long)Math.min(x,y)*2 + (long)Math.max(x,y));
            cnt++;
        }

        return cnt;
    }
}