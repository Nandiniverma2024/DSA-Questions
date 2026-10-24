class Solution {
    public int mostFrequent(int[] nums, int key) {
        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n-1; i++){
            if(nums[i]==key){
                int target=nums[i+1];
                map.put(target, map.getOrDefault(target, 0)+1);
            }
        }
        int ans=0;
        int maxFreq=0;
        for(int k:map.keySet()){
            int freq=map.get(k);
            if(freq>maxFreq){
                maxFreq=freq;
                ans=k;
            }
        }
        return ans;
    }
}