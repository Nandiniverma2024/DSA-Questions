class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int k=set.size();

        return atMost(nums, k) - atMost(nums, k-1);
    }
    public int atMost(int nums[], int k){
        if(k<0){
            return 0;
        }
        int left=0, right=0, n=nums.length;
        int cnt=0;
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
                // agr left++ ke bad
                // fir se map ka size k ke equal ho gya to
                cnt+=right-left+1;
                right++;
            }
        }
        return cnt;
    }
}