class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int mjCount=0;
        for(int i=0; i<n; i++){
            int count=0;
            int len=0;
            for(int j=i; j<n; j++){
                if(nums[j]==target){
                    count++;
                }
                len++;
                if(count>len/2){
                    mjCount++;
                }
            }
        }
        return mjCount;
    }
}