class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left=0, right=0;
        int n=nums.length;
        // Total number of windows
        int res[]=new int[n-k+1]; //+1 => because of 0 based indexing
        int idx=0;

        Deque<Integer> dq=new ArrayDeque<>();

        while(right<n){
            // step 1: buid queue to find max el(int decending order)
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[right]){
                dq.pollLast();
            }
            // Step2: push into Queue
            dq.offerLast(right);

            if(right-left+1 < k){
                right++;
            }else if(right-left+1 == k){
                res[idx]=nums[dq.peekFirst()];
                idx++;

                if(dq.peekFirst() == left){
                    dq.pollFirst();
                }
                //  slide the window
                left++;
                right++;
            }
        }
        return res;
    }
}