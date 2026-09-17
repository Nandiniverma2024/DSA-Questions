class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int cnt=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=1; i<n; i++){
            if(nums[i-1] == nums[i]){
                cnt^=nums[i];
            }
        }
        return cnt;
    }
}