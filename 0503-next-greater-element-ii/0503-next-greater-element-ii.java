class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int cirArr[]=new int[2*n];
        int m=cirArr.length;
        int res[]=new int[n];

        // Fill circular Array
        for(int i=0; i<m; i++){
            cirArr[i]=nums[i%n];
        }

        for(int i=0; i<n; i++){
            int nge=-1;
            // res array ka size 'n' h to outer loop n tak chalega
            for(int j=i+1; j<m; j++){
                if(cirArr[j]>cirArr[i]){
                    nge=cirArr[j];
                    break;
                }
            }
            res[i]=nge;
        }
        return res;
    }
}