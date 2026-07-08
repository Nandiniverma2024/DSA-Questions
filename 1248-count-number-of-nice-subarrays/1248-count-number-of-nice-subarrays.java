class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        // make it binary
        for(int i=0; i<n; i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }else{
                nums[i]=1;
            }
        }

        return atMost(nums, k) - atMost(nums, k-1);
    }
    public int atMost(int nums[], int k){
        int left=0, right=0; 
        int n=nums.length;
        int sum=0;
        int count=0;
        while(right<n){
            // do calculations
            sum+=nums[right];
            while(sum>k){
                sum-=nums[left];
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}