class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int i=0;
        int len=0, maxLen=Integer.MIN_VALUE;
        while(i<n){
            int j=i;
            while(j+1<n && nums[j+1]>nums[j]){
                j++;
            }
            len=j-i+1;
            maxLen=Math.max(maxLen, len);
            i=j+1;
        }
        
        i=0;
        while(i<n){
            int j=i;
            while(j+1<n && nums[j+1]<nums[j]){
                j++;
            }
            len=j-i+1;
            maxLen=Math.max(maxLen, len);
            i=j+1;
        }

        return maxLen;
    }
}