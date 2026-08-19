class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
    
        solve(candidates, target, 0, li, ans);

        return ans;

    }
    public void solve(int[] candidates, int target, int i, List<Integer> li, List<List<Integer>> ans){
        // Base Case
        if(i==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        // agr target negative ho jay to add it backtrack from there
        if(target<0){
            return;
        }

        // Taken
        li.add(candidates[i]);
        solve(candidates, target-candidates[i], i, li, ans);
        li.remove(li.size()-1);

        // Not Taken
        solve(candidates, target, i+1, li, ans);
    }
}