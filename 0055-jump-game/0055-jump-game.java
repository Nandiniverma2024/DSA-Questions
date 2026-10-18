class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx=0;
        for(int i=0; i<nums.length; i++){
            if(i>maxIdx){
                return false;
            }
            // i+nums[i] => ki ek idx se kitni max jump li ja sakti h
            maxIdx=Math.max(maxIdx, i+nums[i]);
        }
        return true;
    }
}