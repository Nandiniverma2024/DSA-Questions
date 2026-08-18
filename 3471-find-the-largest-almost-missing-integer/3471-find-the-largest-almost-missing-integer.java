class Solution {
    public int largestInteger(int[] nums, int k) {
        
        // map => el, freq(no of subarry jinme vo el aa rha h)
        HashMap<Integer, Integer> map=new HashMap<>();
        int left=0, right=k-1;
        int n=nums.length;


        int largest=-1;
        if(n==k){
            for(int i=0; i<n; i++){
                largest=Math.max(largest, nums[i]);
            }
            return largest;
        }
        while(right<n){
            for(int i=left; i<=right; i++){
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }
            left++;
            right++;
        }

        for(int key:map.keySet()){
            if(map.get(key)==1){
                if(largest<key){
                    largest=key;
                }
            }
        }

        // if(largest==Integer.MIN_VALUE){
        //     return -1;
        // }
        return largest;
    }
}