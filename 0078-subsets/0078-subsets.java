class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();

        solve(nums, 0, li, ans);

        return ans;  //(since return type of helper func is void)
    }
    public void solve(int nums[], int i, List<Integer> li, List<List<Integer>> ans){
        // base Case
        if(i==nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }

        // Choice 1 => Take el
        li.add(nums[i]);
        solve(nums, i+1, li, ans);
        // Backtrack(remove last el)
        li.removeLast();

        // Choice 2 => not take any el
        solve(nums, i+1, li, ans);
    }
}