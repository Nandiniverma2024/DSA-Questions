class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        int nums[]={1,2,3,4,5,6,7,8,9};
        solve(nums, k, n, 0, 0, li, ans);

        return ans;
    }
    public void solve(int nums[], int k, int n, int i, int sum, List<Integer> li, List<List<Integer>> ans){
        if(i==nums.length){
            if(sum==n && li.size()==k){
                ans.add(new ArrayList<>(li));
            }
            return;
        }

        // Taken
        li.add(nums[i]);
        sum+=nums[i];
        solve(nums, k, n, i+1, sum, li, ans);
        sum-=nums[i];
        li.remove(li.size()-1); //backtrack

        // Not Taken
        solve(nums, k, n, i+1, sum, li, ans);
    }
}