class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        int candidates[]={1,2,3,4,5,6,7,8,9};

        solve(candidates, k, n, 0, li, ans);

        return ans;

    } 
    public void solve(int arr[], int k, int target, int idx, List<Integer> li,List<List<Integer>> ans){
        // Base Case
        if(k==0 && target==0){
            // sum=target=> meri ouput list m ek combination aa chuka 
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i=idx; i<arr.length; i++){
            if(arr[i]>target){
                break;
            }
           
            li.add(arr[i]);
            solve(arr, k-1, target-arr[i], i+1, li, ans);
            li.remove(li.size()-1);
        }
    }
}

// k=3, n=7

// _  _  _

//  |
//  1-9
