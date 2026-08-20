class Solution {
    public boolean divideArray(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        // odd freq h to pair nhi hoga , return false(pair sirf even freq se bn sakta h)
        for(int key:map.keySet()){
            int freq=map.get(key);
            if(freq%2!=0){
                return false;
            }
        }
        return true;
    }
}