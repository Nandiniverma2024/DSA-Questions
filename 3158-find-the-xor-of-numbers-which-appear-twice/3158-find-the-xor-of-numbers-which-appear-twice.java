class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int xor=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=1; i<n; i++){
            if(nums[i-1] == nums[i]){
                xor^=nums[i];
            }
        }
        return xor;
    }
}