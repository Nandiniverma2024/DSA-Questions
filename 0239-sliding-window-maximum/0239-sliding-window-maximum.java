class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left=0, right=0;
        int n=nums.length;
        // n-k+1 => 
        // 0=>1 window bn chuki, 1=> 2 window ..... , n-k => n-k+1 windows
        // 0=> starting point of 1st window, ending point=>n-k starting point of last window
        int ans[]=new int[n-k+1];
        int idx=0;

        Deque<Integer> dq=new ArrayDeque<>();

        while(right<n){
            // calculation

            // Step2:
            while(!dq.isEmpty() && (nums[dq.peekLast()]<nums[right])){
                dq.pollLast();
            }

            // Step1: Add current index
            dq.offerLast(right); //i.e add from last

            if(right-left+1 < k){
                right++;
            }else if(right-left+1 == k){
                // Find ans from cal
                ans[idx]=nums[dq.peekFirst()];
                idx++;

                if(nums[dq.peekFirst()] == nums[left]){
                    dq.pollFirst();
                }
                left++;
                right++;
            }
        }
        return ans;
    }
}