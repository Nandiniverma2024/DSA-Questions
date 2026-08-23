class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();

        solve(n, k, 1, li, ans);

        return ans;
    }
    public void solve(int n, int k, int startIdx, List<Integer> li, List<List<Integer>> ans){
        if(li.size()==k){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=startIdx; i<=n; i++){
            li.add(i);
            solve(n, k, i+1, li, ans);
            li.remove(li.size()-1);
        }
    }
}

// [1,2,3,4] => [1,2] [1,3] [1,4]
// [2,3] [3,4]
// [4,1] 