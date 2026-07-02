class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0, right=0;
        int maxLen=0;
        int n=nums.length;
        int zeros=0;

        while(right<n){
            if(nums[right]==0){
                zeros++;
            }
            if(zeros<=k){
                maxLen=Math.max(maxLen, right-left+1);
            
            // else if(zeros==k){
            //     maxLen=Math.max(maxLen, right-left+1);
            }else if(zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            right++;
        }
        return maxLen;
    }
}