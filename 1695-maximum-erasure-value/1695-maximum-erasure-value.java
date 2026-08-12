class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int left=0, right=0, n=nums.length;

        int sum=0, maxSum=0;

        while(right<n){
            // Do calculations
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            int k=map.size();
            sum+=nums[right]; //cal. sum globally for each iteration

            if(right-left+1 < k){
                right++;
            }else if(right-left+1 == k){ //when i have unique char, cal sum
                maxSum=Math.max(maxSum, sum); 
                right++;
            }else if(right-left+1 > k){
                while(right-left+1>k){
                    sum-=nums[left];
                    map.put(nums[left], map.get(nums[left])-1);
                    if(map.get(nums[left])==0){
                        map.remove(nums[left]);
                    }
                    left++;
                }
                right++;
            }
        }
        return maxSum;
    }
}