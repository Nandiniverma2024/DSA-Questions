class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        boolean visited[]=new boolean[nums.length];

        solve(nums, li, visited, ans);

        return ans;
    }
    public void solve(int arr[], List<Integer> li, boolean visited [], List<List<Integer>> ans){
        // Base Case
        if(li.size()==arr.length){
            if(!ans.contains(li)){
                ans.add(new ArrayList<>(li));
                return;
            }
        }

        for(int i=0; i<arr.length; i++){
            if(visited[i]==true){
                continue; //skip el for next level
            }

            li.add(arr[i]);
            visited[i]=true; 
            solve(arr, li, visited, ans);
            // do baacktrack when we hit base case
            // backtrack (ye bache hua steps h previous call ke)
            li.remove(li.size()-1);
            visited[i]=false;
        }
    }
}