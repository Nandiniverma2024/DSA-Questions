class Solution {
    public int dominantIndex(int[] nums) {
        int n=nums.length;
        int largest=Integer.MIN_VALUE;
        int idx=0;
        for(int i=0; i<n; i++){
            if(nums[i]>largest){
                largest=nums[i];
                idx=i;
            }
        }

        for(int i=0; i<n ; i++){
            if(i!=idx && largest < nums[i]*2){
                return -1;
            }
        }
        return idx;
    }
}