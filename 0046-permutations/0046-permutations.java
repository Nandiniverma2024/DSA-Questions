class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        boolean visited[]=new boolean[nums.length];

        solve(nums, visited,  li, ans);
        return ans;
    }
    public void solve(int arr[], boolean visited[], List<Integer> li, List<List<Integer>> ans){

        if(li.size()==arr.length){
            ans.add(new ArrayList<>(li));
            return;
        } 
        
        for(int i=0; i<arr.length; i++){
            // for rest of (n-1) operations
            // 1 | 2 | 3 => to skip any el, do continue it

            // jo bi el visit kra, do kip that el with help of boolean array
            if(visited[i] == true){
                continue;
            }
            li.add(arr[i]);

            visited[i]=true;
            solve(arr, visited, li, ans);
            li.remove(li.size()-1);
            visited[i]=false;
        }       
    }
}