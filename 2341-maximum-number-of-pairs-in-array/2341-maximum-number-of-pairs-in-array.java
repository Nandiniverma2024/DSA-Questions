class Solution {
    public int[] numberOfPairs(int[] nums) {
        int res[]=new int[2];
        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int key:map.keySet()){
            int freq=map.get(key);
            res[0]+=freq/2;
            res[1]+=freq%2;
        }
        return res;
    }
}