class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum=0;
        int n=nums.length;
        for(int i=0; i<n; i++){

            // if both left neighbour and right neighbour exist
            if(i-k>=0 && i+k<n){
                if(nums[i-k]<nums[i] && nums[i]>nums[i+k]){
                    sum+=nums[i];
                }
            }
            // if only left neighbour exist
            else if(i-k>=0){
                if(nums[i-k]<nums[i]){
                    sum+=nums[i];
                }
            }
            // if only right neighbour exist
            else if(i+k<n){
                if(nums[i+k]<nums[i]){
                    sum+=nums[i];
                }
            }
            // if Neither left nor right neighbor exists
            else{
                sum+=nums[i];
            }
        }
        return sum;
    }
}