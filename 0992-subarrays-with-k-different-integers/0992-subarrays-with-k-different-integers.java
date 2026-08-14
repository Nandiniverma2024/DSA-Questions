class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }


    public int atMost(int[] nums, int k) {
        int left=0, right=0, n=nums.length, cnt=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        while(right<n){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            if(map.size()<=k){
                cnt+=right-left+1;
                right++;
            }else if(map.size()>k){
                while(map.size()>k){
                    map.put(nums[left], map.get(nums[left])-1);
                    if(map.get(nums[left])==0){
                        map.remove(nums[left]);
                    }
                    left++;
                }
                // yha fir se map ka size k ke equal aa gya h, to cal again
                cnt+=right-left+1;
                right++;
            }
        }
        return cnt;
    }
}