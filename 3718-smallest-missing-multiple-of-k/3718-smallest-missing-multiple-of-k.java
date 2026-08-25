class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<n; i++){
            if(nums[i]%k == 0){
                set.add(nums[i]); 
            }
        }
        // aasa possible missing num jarur hoga jo k ka multiple ho, 100 wali condition 102, 104 ke lia glt ans degi
        for(int i=k; ; i+=k){
            if(!set.contains(i)){
                return i;
            }
        }
    }
}