class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        Arrays.sort(nums);

        solve(nums, 0, li, ans);

        return ans;
    }
    public void solve(int nums[], int idx, List<Integer> li, List<List<Integer>> ans){
        ans.add(new ArrayList<>(li)); //add combinations at each step

        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            // Take choice
            li.add(nums[i]);
            solve(nums, i+1, li, ans);
            li.remove(li.size()-1);
        }
    }
}