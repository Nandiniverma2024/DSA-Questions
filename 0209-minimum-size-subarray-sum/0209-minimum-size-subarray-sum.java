class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int left=0, right=0;
        int minLen=Integer.MAX_VALUE, sum=0;
        while(right<n){
            sum+=nums[right];
            if(sum<target){
                right++;
            }else if(sum>=target){
                while(sum>=target){
                    minLen=Math.min(minLen, right-left+1);
                    sum-=nums[left];
                    left++;
                }
                right++;
            }
        }
        if(minLen==Integer.MAX_VALUE){
            return 0;
        }
        return minLen;
    }
}