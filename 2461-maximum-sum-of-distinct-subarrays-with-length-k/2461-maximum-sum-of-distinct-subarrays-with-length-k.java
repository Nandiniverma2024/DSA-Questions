class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int left=0, right=0;
        long maxSum=0;
        long sum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        while(right<n){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            sum += nums[right];
            if(right-left+1<k){
                right++;
            }else if(right-left+1==k){
                if(map.size()==k){
                    maxSum=Math.max(sum, maxSum);
                }
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                sum-=nums[left];
                left++;
                right++;
            }
        }
        return maxSum;
    }
}