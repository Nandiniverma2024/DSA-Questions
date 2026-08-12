class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);

        // map => (Prefix sum,freq)

        int n=nums.length;
        int sum=0, prefixSum=0;


        for(int i=0; i<n; i++){
            sum+=nums[i];
            prefixSum=sum-goal;
            if(map.containsKey(prefixSum)){
                cnt+=map.get(prefixSum);
            }
            
            map.put(sum, map.getOrDefault(sum, 0)+1);
            
        }
        return cnt;
    }
}