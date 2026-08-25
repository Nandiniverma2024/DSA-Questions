class Solution {
    public int averageValue(int[] nums) {
        int n=nums.length;
        int sum=0, cnt=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0 && nums[i]%3==0){
                sum+=nums[i];
                cnt++;
            }
        }
        if(cnt==0){
            return 0;
        }
        return sum/cnt;
    }
}