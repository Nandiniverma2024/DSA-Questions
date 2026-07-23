class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        // Base case
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int ans=1;

        while(ans<=n){
            // ans<<=1; //left shift ans by 1
            ans=ans*2;
        }

        return ans;
    }
}