class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
        
    }
    public int atMost(int[] nums, int goal) {
        if(goal<0){
            return 0;
        }
        int left=0, right=0, n=nums.length;
        int sum=0;
        int len=0;

        while(right<n){
            sum+=nums[right];
            if(sum<=goal){
                // jitni length h utne hi subarray h
                // indx=0, len=1, subarrya=1
                // indx=1, len=2, subarrya=2
                // indx=2, len=3, subarrya=3
                len+=right-left+1;
                right++;
            }else if(sum > goal){
                // This while loop changing sum in every iteration, prefix is also changing in every iteration so i must need to use expression
                while(sum > goal){
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