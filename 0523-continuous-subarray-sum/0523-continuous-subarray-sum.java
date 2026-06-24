class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);
        
        int currSum=0;
        int len=0;
        for(int i=0; i<n; i++){
            currSum+=nums[i];
            int rem=currSum%k;
            if(map.containsKey(rem)){
                int si=map.get(rem);
                len=i-si;

                if(len>=2){
                    return true;
                }
            }
            if(!map.containsKey(rem)){
                map.put(rem,i);
            }
        }
        return false;
    }
}