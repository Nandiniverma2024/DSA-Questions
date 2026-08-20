class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]%2==0){
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }
        }

        // find maxFreq(most frequent apper el)
        int maxFreq=Integer.MIN_VALUE;
        for(int key : map.keySet()){
            int freq=map.get(key);
            if(maxFreq<freq){
                maxFreq=freq;
            }
        }
        int fc=Integer.MAX_VALUE; //frequent charac
        for(int key:map.keySet()){
            if(map.get(key)==maxFreq){
                if(key<fc){
                    fc=key;
                }
            }
        }
        if(fc==Integer.MAX_VALUE){
            return -1;
        }
        return fc;
    }
}