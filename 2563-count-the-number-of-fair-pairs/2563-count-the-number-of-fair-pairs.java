class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return atMost(nums, upper) - atMost(nums, lower-1);
        // atMost => ye ya isse km
    }
    public long atMost(int nums[], int target){
        int n=nums.length;
        long ans=0;
        int left=0, right=n-1;
        while(left<right){
            if((nums[left]+nums[right]) <= target){
                ans+=right-left;
                left++;
            }else{
                right--; 
            } 
        }
        return ans;
    }
}