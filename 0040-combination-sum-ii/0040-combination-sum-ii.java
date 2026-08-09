class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, li, ans);

        return ans;
    }
    public void solve(int arr[], int target, int idx, List<Integer> li, List<List<Integer>> ans){
        // idx=> for horixzontal call
        // i => for vertical call
        // Base Case
        if(target==0){
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i=idx; i<arr.length; i++){
            // For generating unique combinations
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }
            // Optimization
            if(arr[i]>target){
                break;
            }
            // Kaam
            li.add(arr[i]);
            solve(arr, target-arr[i], i+1, li, ans);
            li.remove(li.size()-1);
        }
    }
}