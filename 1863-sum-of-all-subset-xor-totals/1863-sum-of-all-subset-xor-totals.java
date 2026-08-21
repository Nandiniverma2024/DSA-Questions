class Solution {
    public int subsetXORSum(int[] nums) {
        int n=nums.length;
        int sum=0;
        ArrayList<Integer> li=new ArrayList<>();
        solve(nums, 0, li,  0);

        for(int i=0; i<li.size(); i++){
            sum+=li.get(i);
        }
        return sum;
    }
    public void solve(int arr[], int i, ArrayList<Integer> li, int xor){
        if(i==arr.length){
            li.add(xor);
            return;
        }
        // Taken
        xor^=arr[i];
        solve(arr, i+1, li, xor);
        xor^=arr[i]; //cancel the choice taken above(Backtracking)

        // Not taken
        solve(arr, i+1, li, xor);
    }
}