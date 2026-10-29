class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int left=0, right=0;
        // Total windows => n-k+1
        int res[]=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        
        while(right<n){
            // Form a desending order queue
            while(!dq.isEmpty() && dq.peekLast()<nums[right]){
                dq.pollLast();
            }
            dq.offer(nums[right]);
            if(right-left+1 < k){
                right++;
            }else if(right-left+1 == k){
                res[left]=dq.peekFirst();
                if(nums[left]==dq.peekFirst()){
                    dq.pollFirst();
                }
                left++;
                right++;
            }
        }

        return res;
    }
}