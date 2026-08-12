class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int zeros=0;
        int len=0, maxLen=0;

        int left=0, right=0;

        while(right<n){
            if(nums[right]==0){
                zeros++;
            }
            if(zeros<=k){
                len=right-left+1;
                maxLen=Math.max(len, maxLen);
                right++;
            }else if(zeros>k){
                while(zeros>k){
                    if(nums[left]==0){
                        zeros--;
                    }
                    left++;
                }
                right++;
            }
        }
        return maxLen;
    }
}