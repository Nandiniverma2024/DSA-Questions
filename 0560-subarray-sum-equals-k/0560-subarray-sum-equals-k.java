class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int currSum=0;
        int count=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        // map =>(sum, sum ki freq)
        for(int i=0; i<n; i++){
            currSum+=nums[i];
            int needed=currSum-k;
            if(map.containsKey(needed)){
                count+=map.get(needed);
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return count;
    }
}

// PrefixSum + k = currSum
// needed=crrSum-target(k);