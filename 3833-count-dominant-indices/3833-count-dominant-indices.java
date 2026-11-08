class Solution {
    public int dominantIndices(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0; i<n-1; i++){
            if(nums[i]>avg(nums, i+1)){
                cnt++;
            }
        }
        return cnt;
    }
    public int avg(int nums[], int start){
        int sum=0, cnt=0;
        for(int i=start; i<nums.length; i++){
            sum+=nums[i];
            cnt++;
        }
        return sum/cnt;
    }
}