class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
 
        solve(nums, 0, li, ans);

        return ans;
    }
    public void solve(int nums[], int i, List<Integer> li,List<List<Integer>> ans){
        if(i==nums.length){
            if(!ans.contains(li)){
                ans.add(new ArrayList<>(li));
            }
            return;      
        }

        // Taken
        li.add(nums[i]);
        solve(nums, i+1, li, ans);
        li.remove(li.size()-1); //backtrack

        // not Taken
        solve(nums, i+1, li, ans);
    }
}