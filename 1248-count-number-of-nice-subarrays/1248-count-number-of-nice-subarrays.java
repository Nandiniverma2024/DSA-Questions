class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Make it Binary
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }else{
                nums[i]=1;
            }
        }

        return atMost(nums, k) - atMost(nums, k-1); 
    }
    public int atMost(int[] nums, int k) {
        int left=0, right=0;
        int n=nums.length, sum=0;
        int len=0;

        // Lekin agar:
        // k = 0
        // toh formula banega:
        // atMost(nums, 0) - atMost(nums, -1)

        if(k<0){
            return 0;
        }

        while(right<n){
            sum+=nums[right];
            // jitni len , utne us index pr present subarrays
            if(sum <= k){ //no of valid subarrays
                len+=right-left+1;
                right++;
            }else if(sum>k){
                while(sum>k){
                    sum-=nums[left];
                    left++;
                }
                len+=right-left+1;
                right++;
            }
        }
        return len;
    }
}