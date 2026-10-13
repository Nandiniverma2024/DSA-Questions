class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]<0){
                nums[i]=Math.abs(nums[i]);
            }
        }

        Arrays.sort(nums);

        long oddSum=0, evenSum=0;
        
            for(int i=0; i<n/2; i++){
                oddSum+=nums[i]*nums[i];
            }
            for(int i=n/2; i<n; i++){
                evenSum+=nums[i]*nums[i];
            }
        

        return evenSum-oddSum;
    }
}