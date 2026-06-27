class Solution {
    public int maximumLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        // map => (num, freq of num)
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        // For unique values in array
        int count=1;

        // check for freq=2 (>=)
        // check for freq=1 (>=)
        for(int key: map.keySet()){
            // check for 1
            if(key==1){
                int freq=map.get(key);
                if(freq%2==0){
                    freq=freq-1;
                }
                count=Math.max(count, freq);
                continue;
                // skip from this iteration and move to next key
            }

            // check for other values
            int curr=key;
            int len=0;

            // check for freq=2 (>=)
            while(map.getOrDefault(curr, 0) >= 2){
                len+=2;
                curr=curr*curr;
            }

            // check for freq=1 (>=)  
            if(map.getOrDefault(curr, 0) >= 1){
                len+=1;
            }else{
                len-=1;
            }   

            count=Math.max(count, len);
        }

        return count;
    }
}