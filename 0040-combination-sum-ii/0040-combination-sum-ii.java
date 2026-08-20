class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();

        Arrays.sort(candidates);
        
        solve(candidates, target, 0, li, ans);

        return ans;
    }
    public void solve(int arr[], int target, int idx, List<Integer> li, List<List<Integer>> ans){
        // Base Case
        if(idx==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        
        if(target<0){
            return;
        }

        // Taken
        li.add(arr[idx]);
        solve(arr, target-arr[idx], idx+1, li, ans);
        li.remove(li.size()-1);

        while(idx+1 < arr.length && arr[idx] == arr[idx+1]) {
            idx++;
        }

        // Not Taken
        solve(arr, target, idx+1, li, ans);
    }
}