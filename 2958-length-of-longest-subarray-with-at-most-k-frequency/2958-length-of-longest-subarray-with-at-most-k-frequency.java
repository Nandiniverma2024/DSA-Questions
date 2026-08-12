class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int minVal=Integer.MAX_VALUE;

        int len=0, maxLen=0;
        
        
        int left=0, right=0, n=nums.length;
        while(right<n){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            if(map.get(nums[right])<=k){
                len=right-left+1;
                maxLen=Math.max(len , maxLen);
                right++;
            }else if(map.get(nums[right]) > k){
                while(map.get(nums[right]) > k){
                    map.put(nums[left], map.get(nums[left])-1);
                    if(map.get(nums[left])==0){
                        map.remove(nums[left]);
                    }
                    left++;
                }
                right++;
            }
        }
        return maxLen;
    }
}