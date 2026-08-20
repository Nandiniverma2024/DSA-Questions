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

        // find frequent character
        int frequentChar=Integer.MAX_VALUE; //frequent char 
        for(int key:map.keySet()){
            if(map.get(key)==maxFreq){ //jb 2 char ki freq, maxFreq ke equal h(eg=> 2, 4)
                if(key<frequentChar){ //then find smallest one (i.e 2)
                    frequentChar=key;
                }
            }
        }

        if(frequentChar==Integer.MAX_VALUE){
            return -1;
        }

        return frequentChar;
    }
}