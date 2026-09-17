class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int subset=1<<n;
        List<List<Integer>> ans=new ArrayList<>();
        for(int num=0; num<subset; num++){
            List<Integer> li=new ArrayList<>(); // hr diff pairs of bit ke lia, make new sub list
            for(int i=0; i<n; i++){
                if((num & (1<<i)) != 0){
                    li.add(nums[i]);
                }
            }
            ans.add(li);
        }
        return ans;
    }
}