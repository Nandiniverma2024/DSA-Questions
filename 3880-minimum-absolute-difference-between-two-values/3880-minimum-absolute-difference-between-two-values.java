class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int minDiff=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[i]==1 && nums[j]==2){
                    int diff=Math.abs(i-j);
                    minDiff=Math.min(minDiff, diff);
                }
            }
        }

        if(minDiff==Integer.MAX_VALUE){
            return -1;
        }

        return minDiff;
    }
}