class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int max[]=new int[n];
        int min[]=new int[n];

        min[n-1]=nums[n-1];

        // Fill max
        max[0]=nums[0];
        for(int i=1; i<max.length; i++){
            max[i]=Math.max(max[i-1], nums[i]);
        }


        // Fill min
        min[n-1]=nums[n-1];
        for(int i=min.length-2; i>=0; i--){
            min[i]=Math.min(min[i+1], nums[i]);
        }

        // Fill Score
        int minIdx=-1;
        for(int i=0; i<n; i++){
            int score=max[i]-min[i];

            if(score<=k){
                minIdx=i;
                break;
            }
        }

        return minIdx;
    }
}